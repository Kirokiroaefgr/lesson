package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.GenreDAO;
import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.GenreDTO;
import com.internousdev.lesson.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;



public class ItemListAction extends ActionSupport {
	private String choiceGenre;

	private String itemGenre;

	/**
	 * 商品を検索するリスト
	 */
	private  List<ItemDTO> itemList = new ArrayList<>();
	private List<GenreDTO> genreList = new ArrayList<>();

	public String execute() {
		choiceGenre=itemGenre;
		GenreDAO genreDao= new GenreDAO();
		genreList = genreDao.selectGenre();

		ItemListDAO itemDao =new ItemListDAO();
		itemList=itemDao.itemSelect(itemGenre,0);
		return SUCCESS;
	}

	/**
	 * @return genreList
	 */
	public List<GenreDTO> getGenreList() {
		return genreList;
	}

	/**
	 * @param genreList セットする genreList
	 */
	public void setGenreList(List<GenreDTO> genreList) {
		this.genreList = genreList;
	}

	/**
	 * @return itemList
	 */
	public List<ItemDTO> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
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
	 * @return choiceGenre
	 */
	public String getChoiceGenre() {
		return choiceGenre;
	}

	/**
	 * @param choiceGenre セットする choiceGenre
	 */
	public void setChoiceGenre(String choiceGenre) {
		this.choiceGenre = choiceGenre;
	}



}
