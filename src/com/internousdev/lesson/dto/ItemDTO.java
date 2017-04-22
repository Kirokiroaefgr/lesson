/**
 *
 */
package com.internousdev.lesson.dto;

/**
 * 商品情報を格納するためのDTOクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/20
 * @version 1.0
 */
public class ItemDTO {

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * ジャンル
	 */
	private String itemGenre;

	/**
	 *   著者
	 */
	private String itemAuthor;

	/**
	 *   発売日
	 */
	private String releaseDate;

	/**
	 * 商品のページ数
	 */
	private int page;

	/**
	 * 価格
	 */
	private float price;

	/**
	 *   図書（書籍）を特定するための番号
	 */
	private String isbm;

	/**
	 * 商品説明詳細
	 */
	private String itemDetail;

	/**
	 * 商品画像01
	 */
	private String itemImg01;

	/**
	 * 商品画像02
	 */
	private String itemImg02;

	/**
	 * 商品画像03
	 */
	private String itemImg03;

	/**
	 * 在庫
	 */
	private int stock;

	/**
	 * 商品削除フラグ
	 */
	private boolean deleteFlg;

	/**
	 * 登録日
	 */
	private String registrationDate;

	/**
	 * 更新日
	 */
	private String updatedDate;

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
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return itemGenre
	 */
	public String getItemGenre() {
		return itemGenre;
	}

	/**
	 * @param itemGenre セットする itemGenre
	 */
	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}

	/**
	 * @return itemAuthor
	 */
	public String getItemAuthor() {
		return itemAuthor;
	}

	/**
	 * @param itemAuthor セットする itemAuthor
	 */
	public void setItemAuthor(String itemAuthor) {
		this.itemAuthor = itemAuthor;
	}

	/**
	 * @return releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate セットする releaseDate
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page セットする page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price セットする price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return isbm
	 */
	public String getIsbm() {
		return isbm;
	}

	/**
	 * @param isbm セットする isbm
	 */
	public void setIsbm(String isbm) {
		this.isbm = isbm;
	}

	/**
	 * @return itemDetail
	 */
	public String getItemDetail() {
		return itemDetail;
	}

	/**
	 * @param itemDetail セットする itemDetail
	 */
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	/**
	 * @return itemImg01
	 */
	public String getItemImg01() {
		return itemImg01;
	}

	/**
	 * @param itemImg01 セットする itemImg01
	 */
	public void setItemImg01(String itemImg01) {
		this.itemImg01 = itemImg01;
	}

	/**
	 * @return itemImg02
	 */
	public String getItemImg02() {
		return itemImg02;
	}

	/**
	 * @param itemImg02 セットする itemImg02
	 */
	public void setItemImg02(String itemImg02) {
		this.itemImg02 = itemImg02;
	}

	/**
	 * @return itemImg03
	 */
	public String getItemImg03() {
		return itemImg03;
	}

	/**
	 * @param itemImg03 セットする itemImg03
	 */
	public void setItemImg03(String itemImg03) {
		this.itemImg03 = itemImg03;
	}

	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock セットする stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return deleteFlg
	 */
	public boolean isDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg セットする deleteFlg
	 */
	public void setDeleteFlg(boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * @return registrationDate
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate セットする registrationDate
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate セットする updatedDate
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}