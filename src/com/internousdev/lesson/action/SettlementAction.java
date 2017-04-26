package com.internousdev.lesson.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.CartDeleteDAO;
import com.internousdev.lesson.dao.CartSelectDAO;
import com.internousdev.lesson.dao.CreditBrandDAO;
import com.internousdev.lesson.dao.CreditPurchaseDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.lesson.util.CartAssist;



/**
 * 決済完了するためのクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/10
 * @version 1.00
 */
public class SettlementAction extends CartAssist implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -1467340805447981887L;

	/**
	 * カート内に入ってる商品の合計金額
	 */
	private float payment;

	/**
	 * カート内に入ってる合計商品数
	 */
	private int order;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * クレジットの種類 1:VISA 2:MasterCard 3:AmericanExpress
	 */
	private int creditBrand;

	/**
	 * クレジット番号16桁の整数
	 */
	private String creditNumber;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * セキュリティコード3桁か4桁の整数
	 */
	private String securityCode;

	/**
	 * お届け先の住所
	 */
	private String shippingAddress;

	/**
	 * カートテーブルの情報を入れるリスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	/**
	 *在庫のゼロの商品を入れるリスト
	 */
	List<CartDTO> msg = new ArrayList<>();

	public String execute() {
		String result = ERROR;

		if (session.containsKey("userId")) {
			userId = (int) session.get("userId");
		} else {
			return LOGIN;
		}

		CreditBrandDAO creditdao = new CreditBrandDAO();
		UsersDTO userDto = creditdao.selectUserInfo(creditBrand, creditNumber, securityCode);

		CartSelectDAO cartDao = new CartSelectDAO();
		cartList = cartDao.selectCart(userId, 0, true);
		this.msg = StockCheck(cartList, userId, 0);
		cartList = cartDao.selectCart(userId, 0, true);
		this.order=totalOrder(cartList);
		this.payment=payment(cartList);
		if (msg.size() != 0) {

			return INPUT;
		}
		if (cartList.size() != 0) {
			CreditPurchaseDAO purchaseDao = new CreditPurchaseDAO(creditBrand);
			CartDeleteDAO cda = new CartDeleteDAO();
			try {
				purchaseDao.CreditPurchaseHistory(userDto, creditBrand, cartList);
				purchaseDao.CetusPurchaseHistory(userId, creditBrand, shippingAddress, cartList);
				cda.delete(userId, 0);
				cda.itemUpdate(cartList);
				purchaseDao.commit();
				cda.itemComit();
				return SUCCESS;
			} catch (SQLException e) {
				purchaseDao.rollback();
				cda.itemRollBack();
				errorMessage= getText("lang.settlement.error05");
				e.printStackTrace();
				return result;
			}
		}
		errorMessage = getText("lang.cart.no");
		return INPUT;
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
	 * @return creditBrand
	 */
	public int getCreditBrand() {
		return creditBrand;
	}

	/**
	 * @param creditBrand セットする creditBrand
	 */
	public void setCreditBrand(int creditBrand) {
		this.creditBrand = creditBrand;
	}

	/**
	 * @return creditNumber
	 */
	public String getCreditNumber() {
		return creditNumber;
	}

	/**
	 * @param creditNumber セットする creditNumber
	 */
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * @param securityCode セットする securityCode
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * @return shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress セットする shippingAddress
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
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
	 * @return msg
	 */
	public List<CartDTO> getMsg() {
		return msg;
	}

	/**
	 * @param msg セットする msg
	 */
	public void setMsg(List<CartDTO> msg) {
		this.msg = msg;
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
