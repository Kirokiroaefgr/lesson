package com.internousdev.lesson.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.CartDeleteDAO;
import com.internousdev.lesson.dao.CartUpdateDAO;
import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.dto.ItemDTO;

/**
 * カート全般の処理と決済のときの処理を補助するクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/10
 * @version 1.0
 */
public class CartAssist {
	private int FirmOrderNumber;

	/**
	 * カートに入ってる商品の合計金額を計算して返すメソッド
	 *
	 * @param cartListカート内商品
	 * @return payment 合計金額
	 */
	public float payment(List<CartDTO> cartList) {
		int payment = 0;
		for (CartDTO cart : cartList) {
			payment += cart.getSubtotal() * cart.getOrderCount();
		}
		return payment;
	}

	/**
	 * カートに入ってる商品数を合計して返すメソッド
	 *
	 * @param cartListカート内商品
	 * @return totalOrder 商品数合計
	 */
	public int totalOrders(List<CartDTO> cartList) {
		int totalOrders = 0;
		for (CartDTO cart : cartList) {
			totalOrders +=cart.getOrderCount();
		}
		return totalOrders;
	}

	/**
	 * 注文数と商品在庫を比較して在庫より上回らないように計算するメソッド
	 * なお在庫が99個以上あっても最大99個までしか買えないようにしてます。
	 *
	 * @param cartNumber カート数
	 * @param orderNumber 商品の注文数
	 * @param itemId 商品ID
	 * @return totalNumber 注文数と商品の在庫数を計算した値
	 */
	public int FirmOrderNumber(int cartNumber, int NumberOfOrders, int itemId) {
		//itemテーブルからitemIdの在庫を取ってくるためにインスタンス化
		ItemListDAO itemStock = new ItemListDAO();
		//itemテーブルからitemIdの在庫を格納するリスト
		List<ItemDTO> itemList = new ArrayList<>();
		//
		itemList = itemStock.itemSelect(null, itemId);
		int stock = Math.min(itemList.get(0).getStock(), 99);
		this.FirmOrderNumber = Math.min(cartNumber + NumberOfOrders, stock);
		return FirmOrderNumber;
	}

	/**
	 * カートと決済するとき、itemテーブルの商品の在庫が0個のとき カートテーブルから商品を削除して 削除した商品の名前を
	 * ArrayListにいれて返すメソッド。
	 *
	 * @param cartList カートリスト
	 * @param userId ユーザーID
	 * @param orderNumber注文数
	 * @return msg msg
	 */
	public List<CartDTO> StockCheck(List<CartDTO> cartList, int userId, int numberOfOrders) {
		// カートに入ってる商品が在庫0になった場合、カートテーブルから削除してその商品名を格納するリスト
		List<CartDTO> msg = new ArrayList<>();
		CartUpdateDAO isInsert = new CartUpdateDAO();
		CartDeleteDAO cda = new CartDeleteDAO();
		for (CartDTO cart : cartList) {
			//在庫が0個または、注文数が変更された商品名と注文数を格納するためにインスタンス化
			CartDTO cartName = new CartDTO();
			this.FirmOrderNumber = FirmOrderNumber(cart.getOrderCount(), numberOfOrders, cart.getItemId());
			if (FirmOrderNumber == 0) {//注文数が0だった場合(在庫が0）
				try {
					//在庫が0個だった商品名をcartNameにセットする。
					cartName.setItemName(cart.getItemName());
					//セットしたあと、在庫が0個だった商品をcartテーブルから削除する。
					cda.delete(userId, cart.getItemId());
					cda.itemComit();
				} catch (SQLException e) {
					cda.itemRollBack();
					e.printStackTrace();
				}
				msg.add(cartName);
			} else if (cart.getOrderCount() != this.FirmOrderNumber) {//注文数より在庫が下回った場合
				//注文数より在庫が下回った商品名をセットする。
				cartName.setItemName(cart.getItemName());
				//注文数より在庫が下回った商品の注文数をセットする。
				cartName.setOrderCount(this.FirmOrderNumber);
				//注文数より在庫が下回ったため商品を、在庫に合わせるためcartテーブルupdateする。
				isInsert.exeUpdate(userId, cart.getItemId(), this.FirmOrderNumber, false);
				msg.add(cartName);
			}
		}
		return msg;
	}
}
