package com.internousdev.lesson.dto;

/**
* カート情報を格納するためのDTOクラス
* @author KEIGO NISHIMORI
* @since 2017/04/05
*/
public class CartDTO {
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
	 * 商品画像01
	 */
	private String itemImg01;

	/**
	 * 商品削除
	 */
	private boolean deleteFlg;

	/**
	 * 登録日
	 */
	private String registration;

	/**
	 * 更新日
	 */
	private String updatedDate;

	/**
	 * ユーザーID取得メソッド
	 * @return userId ユーザーID
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーID格納メソッド
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * アイテムID取得メソッド
	 * @return itemId アイテムID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * アイテムID格納メソッド
	 * @param itemId アイテムID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 注文数取得メソッド
	 * @return orderCount 注文数
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * 注文数格納メソッド
	 * @param orderCount 注文数
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	/**
	 * デリートフラグ取得メソッド
	 * @return deleteFlg デリートフラグ
	 */
	public boolean isDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * デリートフラグ格納メソッド
	 * @param deleteFlg デリートフラグ
	 */
	public void setDeleteFlg(boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * 登録日取得メソッド
	 * @return registration  登録日
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * 登録日格納メソッド
	 * @param registration  登録日
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	/**
	 * 更新日取得メソッド
	 * @return updatedDate 更新日
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 更新日格納メソッド
	 * @param updatedDate 更新日
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * 小計取得メソッド
	 * @return subtotal 小計
	 */
	public float getSubtotal() {
		return subtotal;
	}

	/**
	 * 小計格納メソッド
	 * @param subtotal 小計
	 */
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * 商品名取得メソッド
	 * @return itemName 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名格納メソッド
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 商品画像1取得メソッド
	 * @return itemImg01  商品画像1
	 */
	public String getItemImg01() {
		return itemImg01;
	}

	/**
	 *  商品画像1格納メソッド
	 * @param itemImg01  商品画像1
	 */
	public void setItemImg01(String itemImg01) {
		this.itemImg01 = itemImg01;
	}


}
