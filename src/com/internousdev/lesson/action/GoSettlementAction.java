package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.CartSelectDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**決済入力画面に遷移するためのクラス
 * @author KEIGO NISHIMORI
 *@since 2017/04/10
 */
public class GoSettlementAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -431922725256631232L;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 合計金額
	 */
	private int payment;

	/**
	 * カート内に入ってる合計商品数
	 */
	private int order;

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	/**
	 *カートの情報を格納
	 */
	private List<CartDTO> cartList = new ArrayList<>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	public String execute() {
		if (session.containsKey("userId")) {
			userId = (int) session.get("userId");
		} else {
			return LOGIN;
		}
		CartSelectDAO cartDao = new CartSelectDAO();
		cartList = cartDao.selectCart(userId, 0, true);
		if (cartList.size() <= 0) {
			errorMessage = getText("lang.cart.no");
			return ERROR;
		}
		return SUCCESS;
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
	 * @return payment
	 */
	public int getPayment() {
		return payment;
	}

	/**
	 * @param payment セットする payment
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}

	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage セットする errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order セットする order
	 */
	public void setOrder(int order) {
		this.order = order;
	}



	}
