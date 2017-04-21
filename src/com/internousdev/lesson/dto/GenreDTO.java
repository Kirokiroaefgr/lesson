package com.internousdev.lesson.dto;

/**
 * 商品ジャンルを格納するためのクラス
 * @author KAZUHIRO UMINOt
 * @since 2017/04/04
 * @version 1.0
 */
public class GenreDTO {

	/**
	 * ジャンルID
	 * */
	private int genreId;

	/**
	 * ジャンル名
	 */
	private String itemGenre;

	/**
	 * 登録日
	 */
	private String registrationDate;

	/**
	 * 更新日
	 */
	private String updatedDate;

	/**
	 * @return genreId
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * @param genreId セットする genreId
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
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
