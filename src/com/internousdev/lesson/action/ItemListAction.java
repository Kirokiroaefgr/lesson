package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.GenreDAO;
import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.GenreDTO;
import com.internousdev.lesson.dto.ItemDTO;
import com.internousdev.lesson.util.PaginationAssist;
import com.opensymphony.xwork2.ActionSupport;



public class ItemListAction extends ActionSupport {
	private String choiceGenre;
	private String itemGenre;
	private int pageNum;
	private int maxPage;
	private int amountSort;
	/**
	 *  ページ数を格納する配列
	 */
	private int[] page;
	private int itemCount;
	private int maxShowingItemCount;
	private int minShowingItemCount;

	/**
	 * 商品を検索するリスト
	 */
	private  List<ItemDTO> itemList = new ArrayList<>();
	private List<GenreDTO> genreList = new ArrayList<>();

	public String execute() {
		if(pageNum==0){
			pageNum=1;
		}
		choiceGenre=itemGenre;

		GenreDAO genreDao= new GenreDAO();
		genreList = genreDao.selectGenre(itemGenre);

		ItemListDAO itemDao =new ItemListDAO();
		minShowingItemCount=(pageNum-1)*12;
		itemList=itemDao.itemSelect(itemGenre,0,minShowingItemCount,amountSort);


		minShowingItemCount++;
		itemCount=itemDao.countSelect(itemGenre,amountSort);
		maxShowingItemCount=pageNum*12;
		if(itemCount<maxShowingItemCount){
			maxShowingItemCount=itemCount;
		}
		maxPage=(int) Math.ceil((double) itemCount / 12);
		PaginationAssist pa=new PaginationAssist();
		page=pa.pagenation(pageNum, maxPage);


		return SUCCESS;
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
	 * @return pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum セットする pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * @param maxPage セットする maxPage
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * @return page
	 */
	public int[] getPage() {
		return page;
	}

	/**
	 * @param page セットする page
	 */
	public void setPage(int[] page) {
		this.page = page;
	}

	/**
	 * @return itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount セットする itemCount
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return maxShowingItemCount
	 */
	public int getMaxShowingItemCount() {
		return maxShowingItemCount;
	}

	/**
	 * @param maxShowingItemCount セットする maxShowingItemCount
	 */
	public void setMaxShowingItemCount(int maxShowingItemCount) {
		this.maxShowingItemCount = maxShowingItemCount;
	}

	/**
	 * @return minShowingItemCount
	 */
	public int getMinShowingItemCount() {
		return minShowingItemCount;
	}

	/**
	 * @param minShowingItemCount セットする minShowingItemCount
	 */
	public void setMinShowingItemCount(int minShowingItemCount) {
		this.minShowingItemCount = minShowingItemCount;
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
	 * @return amountSort
	 */
	public int getAmountSort() {
		return amountSort;
	}

	/**
	 * @param amountSort セットする amountSort
	 */
	public void setAmountSort(int amountSort) {
		this.amountSort = amountSort;
	}





}
