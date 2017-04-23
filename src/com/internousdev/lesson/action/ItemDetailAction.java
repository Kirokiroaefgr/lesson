package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport {
	private int itemId;
	private  List<ItemDTO> itemList = new ArrayList<>();
	public String execute() {
		ItemListDAO itemDao =new ItemListDAO();
		itemList=itemDao.itemSelect(null,itemId);
		return SUCCESS;
	}
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

}
