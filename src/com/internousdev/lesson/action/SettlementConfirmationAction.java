package com.internousdev.lesson.action;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.CartSelectDAO;
import com.internousdev.lesson.dao.CreditBrandDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.lesson.util.CartAssist;



/**決済確認画面に遷移するためのクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/10
 * @version 1.00
 */
public class SettlementConfirmationAction extends CartAssist implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -3086205813931601244L;

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
	 * クレジットカードの最初の6桁
	 */
	private String checkNumber;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * クレジットカードの使用期限(月)
	 */
	private String expirationMonth;

	/**
	 * クレジットカードの使用期限(年)
	 */
	private String expirationYear;

	/**
	 * セキュリティコード3桁か4桁の整数
	 */
	private String securityCode;

	/**
	 * お届け先の住所
	 */
	private String shippingAddress;

	/**
	 * 合計金額
	 */
	private float payment;

	/**
	 * 合計注文数
	 */
	private int totalOrder;

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


	public String execute() {
		String result = ERROR;
		CreditBrandDAO creditdao = new CreditBrandDAO();
		/* カード番号の上6桁を取得 */

		if (session.containsKey("userId")) {
			userId = (int) session.get("userId");
		} else {
			return LOGIN;
		}

		CartSelectDAO cartDao = new CartSelectDAO();
		cartList = cartDao.selectCart(userId, 0, true);
		if (cartList.size() <= 0) {
			errorMessage = "カートに何も入ってません。";
			return INPUT;
		}
		this.totalOrder=totalOrder(cartList);
		this.payment=payment(cartList);

		/* VISA or MasterCard */
		/* クレジットカード番号の桁数をチェックする処理 */
		checkNumber = creditNumber.substring(0, 6);
		if (!(creditdao.select(creditBrand, checkNumber))) {
			errorMessage = "クレジットカードの種類が違う可能性があります。";
			return result;
		}

		UsersDTO userDto = creditdao.selectUserInfo(creditBrand, creditNumber,securityCode);
		if (userDto.getPassword() == null) {
			errorMessage = "クレジットカード番号またはセキュリティコードがまちがってます。";
			return result;
		}

		/* 現在の年と月の取得 */
		LocalDateTime time = LocalDateTime.now();
		int month =time.get(ChronoField.MONTH_OF_YEAR);
		int year = time.getYear() % 100;
		int intExMonth = Integer.parseInt(expirationMonth);
		int intExYear = Integer.parseInt(expirationYear);
		//クレジットカードの期限がきれてないか確認。
		if (intExYear < year) {
			errorMessage = "期限が切れてます。";
			return result;
		} else if ((intExYear == year) && (intExMonth < month)) {
			errorMessage = "期限が切れてます。";
			return result;
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
	 * @return checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}


	/**
	 * @param checkNumber セットする checkNumber
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
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
	 * @return expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}


	/**
	 * @param expirationMonth セットする expirationMonth
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}


	/**
	 * @return expirationYear
	 */
	public String getExpirationYear() {
		return expirationYear;
	}


	/**
	 * @param expirationYear セットする expirationYear
	 */
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
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
	 * @return totalOrder
	 */
	public int getTotalOrder() {
		return totalOrder;
	}


	/**
	 * @param totalOrder セットする totalOrder
	 */
	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
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

}
