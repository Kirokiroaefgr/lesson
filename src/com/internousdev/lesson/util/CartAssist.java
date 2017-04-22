package com.internousdev.lesson.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.CartDeleteDAO;
import com.internousdev.lesson.dao.CartUpdateDAO;
import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート全般の処理と決済のときの処理を補助するクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/10
 * @version 1.0
 */
public class CartAssist extends ActionSupport{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2050643094744275831L;
	private float payment;
	private int totalOrder;
	private int totalNumber;

	/**
	 * カートに入ってる商品の合計金額を計算して返すメソッド
	 *
	 * @param cartList カート内商品
	 * @return payment 合計金額
	 */
	public float payment(List<CartDTO> cartList) {
		cartList.forEach(cart -> payment += cart.getSubtotal() * cart.getOrderCount());
		return payment;
	}

	/**
	 * カートに入ってる商品数を合計して返すメソッド
	 *
	 * @param cartList カート内商品
	 * @return totalOrder 商品数合計
	 */
	public int totalOrder(List<CartDTO> cartList) {
		cartList.forEach(cart -> totalOrder += cart.getOrderCount());
		return totalOrder;
	}

	/**
	 * 注文数と商品在庫を比較して在庫より上回らないように計算してセットするメソッド
	 * なお在庫が99個以上あっても最大99個までしか買えないようにしてます。
	 * @param cartNumber カート数
	 * @param orderNumber 商品の注文数
	 *
	 * @param itemId 商品ID
	 * @return totalNumber 注文数と商品の在庫数を計算した値
	 */
	public int totalNumber(int cartNumber,int orderNumber, int itemId) {
		ItemListDAO itemStock = new ItemListDAO();
		List<ItemDTO> itemList = new ArrayList<>();
		itemList = itemStock.itemSelect(null,itemId,0,0);
		int stock = Math.min(itemList.get(0).getStock(), 99);
		this.totalNumber = Math.min(cartNumber + orderNumber, stock);
		return this.totalNumber;
	}

	/**
	 * カートと決済するとき、itemテーブルの商品の在庫が0個のとき
	 * カートテーブルから商品を削除して　削除した商品の名前を
	 * ArrayListにいれて返すメソッド。
	 *
	 * @param cartList カートリスト
	 * @param userId ユーザーID
	 * @param orderNumber 注文数
	 * @return msg msg
	 */
	public List<CartDTO> StockCheck(List<CartDTO> cartList,int userId,int orderNumber){
		List<CartDTO> msg= new ArrayList<>();
		CartUpdateDAO isInsert = new CartUpdateDAO();
		CartDeleteDAO cda =  new CartDeleteDAO();
		for(CartDTO cart: cartList){
			CartDTO cartName= new CartDTO();
			this.totalNumber=totalNumber(cart.getOrderCount(),orderNumber,cart.getItemId());
			if(totalNumber<=0){
				try {
					cartName.setItemName(cart.getItemName());
					cda.delete(userId, cart.getItemId());
					cda.itemComit();
				} catch (SQLException e) {
					cda.itemRollBack();
					e.printStackTrace();
				}
				msg.add(cartName);
			}else if(cart.getOrderCount()!=this.totalNumber){
				cartName.setItemName(cart.getItemName());
				cartName.setOrderCount(this.totalNumber);
				isInsert.exeUpdate(userId,cart.getItemId(), this.totalNumber, false);
				msg.add(cartName);
			}
		}
		return msg;
	}
}
