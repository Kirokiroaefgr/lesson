package com.internousdev.lesson.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.CartDeleteDAO;
import com.internousdev.lesson.dao.CartSelectDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.util.CartAssist;
import com.opensymphony.xwork2.ActionSupport;



/**
 *  カートの中身を削除するクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/21
 * @version 1.0
 */

public class CartDeleteAction extends ActionSupport implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -507759064447081358L;

	/**
	 * カート内の商品数の合計金額
	 */
	private float payment;

	/**
	 * カート内に入ってる合計商品数
	 */
	private int totalOrders;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 検索したカート内の商品の情報を入れるリスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();

	/**
	 * [概 要] 戻り値の型に合わせてキャスト
	 * @return castObj
	 * @param obj オブジェ
	 * @param <T> t
	 */
	@SuppressWarnings("unchecked")
	public static <T> T autoCast(Object obj) {
		T castObj = (T) obj;
		return castObj;
	}

	/**
	 * 実行メソッド
	 * カートの中身を削除するメソッド
	 */
	public String execute() {

		//cartの在庫チェック・合計注文数などを処理するクラスをインスタンス化
		CartAssist assist=new CartAssist();

		// 商品のitemIDと注文数を入れるためのHashMap
		Map<Integer, Integer> cartSession = new HashMap<>();
		CartSelectDAO certDao = new CartSelectDAO();
		CartDeleteDAO cda =  new CartDeleteDAO();

		//▼▼ログインしてるときの処理 ここから▼▼
		if (session.containsKey("userId")) {
			userId = (int) session.get("userId");
			try {
				cda.delete(userId,itemId);
				cda.itemComit();
			} catch (SQLException e) {
				cda.itemRollBack();
				e.printStackTrace();
			}

			cartList = certDao.selectCart(userId, itemId, true);
			this.totalOrders=assist.totalOrders(cartList);
			this.payment=assist.payment(cartList);

			//▲▲ログインしてるときの処理 ここまで▲▲


			// ▼▼ログインしてないときの処理 ここから▼▼
		}else if(session.containsKey("cartSession")){
			cartSession = autoCast(session.get("cartSession"));
			cartSession.remove(itemId);
			session.put("cartSession", cartSession);
			cartList = certDao.displayCart(cartSession);
			this.totalOrders=assist.totalOrders(cartList);
			this.payment=assist.payment(cartList);
		}

		// ▲▲ログインしてないときの処理 ここまで▲▲

		return SUCCESS;
	}

	/**
	 * @return payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 * @param payment セットする payment
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * @return totalOrders
	 */
	public int getTotalOrders() {
		return totalOrders;
	}

	/**
	 * @param totalOrders セットする totalOrders
	 */
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}