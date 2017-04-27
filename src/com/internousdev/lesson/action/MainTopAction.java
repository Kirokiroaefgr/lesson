package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.internousdev.lesson.dao.ItemListDAO;
import com.internousdev.lesson.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MainTopAction extends ActionSupport{
	private List<ItemDTO> itemList = new ArrayList<>();
	private List<ItemDTO> displayList = new ArrayList<>();
	public String execute(){
		ItemDTO dto=new ItemDTO();
		ItemListDAO dao=new ItemListDAO();
		itemList=dao.mainTopSelect();
		Random rand = new Random();
		for(int i=0; i<3;i++){
		int num = rand.nextInt(itemList.size());
		dto=itemList.get(num);
		displayList.add(dto);
		}
		return SUCCESS;
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
	 * @return displayList
	 */
	public List<ItemDTO> getDisplayList() {
		return displayList;
	}
	/**
	 * @param displayList セットする displayList
	 */
	public void setDisplayList(List<ItemDTO> displayList) {
		this.displayList = displayList;
	}


}
