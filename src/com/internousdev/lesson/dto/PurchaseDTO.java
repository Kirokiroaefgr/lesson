/**
 *
 */
package com.internousdev.lesson.dto;


/**
 * 購入履歴を格納するためのDTOクラス
 * @author KEIGO NISHIMORI
 */
    public class PurchaseDTO {
	/**
	 * 購入ID
	 */
	private int purchaseId;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 注文数
	 */
	private int orderCount;
	/**
	 * 小計
	 */
	private float subtotal;
	/**
	 * 支払い方法
	 */
	private int paymentMethod;

	/**
	 * 発送先住所
	 */
	private String shippingAddress;

	/**
	 * 購入日
	 */
	private String purchaseDate;

	/**
	 * 更新日
	 */
	private String updatedDate;

	/**
	 * 購入ID取得メソッド
	 * @return purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}

	/**
	 * 購入ID格納メソッド
	 * @param purchaseId セットする purchaseId
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * ユーザーID取得メソッド
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 商品ID取得メソッド
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品ID格納メソッド
	 * @param itemId セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品名取得メソッド
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名格納メソッド
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 注文数取得メソッド
	 * @return orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * 注文数格納メソッド
	 * @param orderCount セットする orderCount
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	/**
	 * 支払い方法取得メソッド
	 * @return paymentMethod
	 */
	public int getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * 支払い方法格納メソッド
	 * @param paymentMethod セットする paymentMethod
	 */
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * 発送先住所取得メソッド
	 * @return shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * 発送先住所格納メソッド
	 * @param shippingAddress セットする shippingAddress
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * 購入日取得メソッド
	 * @return purchaseDate
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * 購入日格納メソッド
	 * @param purchaseDate セットする purchaseDate
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * 更新日取得メソッド
	 * @return updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 更新日格納メソッド
	 * @param updatedDate セットする updatedDate
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * 小計取得メソッド
	 * @return subtotal
	 */
	public float getSubtotal() {
		return subtotal;
	}
	/**
	 * 小計を格納メソッド
	 * @param subtotal セットする subtotal
	 */
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


}
