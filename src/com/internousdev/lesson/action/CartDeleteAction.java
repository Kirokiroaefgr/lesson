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



/**
 *  カートの中身を削除するクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/21
 * @version 1.0
 */

public class CartDeleteAction extends CartAssist implements SessionAware{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -507759064447081358L;

	/**
	 * 　カート内の商品数の合計金額
	 */
	private float payment;

	/**
	 * 　カート内の商品数
	 */
	private int order;

	/**
	 * 　ユーザーID
	 */
	private int userId;

	/**
	 * 　商品ID
	 */
	private int itemId;

	/**
	 * 　セッション
	 */
	private Map<String, Object> session;

	/**
	 * 　検索したカート内の商品の情報を入れるリスト
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
		String result = SUCCESS;
		Map<Integer, Integer> cartOrder = new HashMap<>();
		CartSelectDAO certDao = new CartSelectDAO();
		CartDeleteDAO cda =  new CartDeleteDAO();
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
			this.order=totalOrder(cartList);
			this.payment=payment(cartList);
			return result;
		}else if(session.containsKey("cartOrderSession")){
			cartOrder = autoCast(session.get("cartOrderSession"));
			cartOrder.remove(itemId);
			session.put("cartOrderSession", cartOrder);
			cartList = certDao.displayCart(cartOrder);
			this.order=totalOrder(cartList);
			this.payment=payment(cartList);
		}

		return result;
	}

	/**
	 * カート内の合計金額を取得するためのメソッド
	 * @return payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 * カート内の合計金額を格納するためのメソッド
	 * @param payment セットする payment
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * カート内の商品数を取得するためのメソッド
	 * @return order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 *  カート内の商品数を格納するためのメソッド
	 * @param order セットする order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * ユーザーIDを取得するためのメソッド
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを格納するためのメソッド
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 商品Idを取得するためのメソッド
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品Idを格納するためのメソッド
	 * @param itemId セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * セッションを取得するためのメソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを格納するためのメソッド
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * カート内の商品情報を取得するためのメソッド
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * カート内の商品情報を格納するためのメソッド
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