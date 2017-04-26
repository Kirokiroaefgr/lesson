package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.LoginDAO;
import com.internousdev.lesson.dao.PurchaseDAO;
import com.internousdev.lesson.dto.PurchaseDTO;
import com.internousdev.lesson.dto.UsersDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MypageAction extends ActionSupport implements SessionAware {
	private int userId;
	private List<UsersDTO> userList = new ArrayList<>();
	private List<PurchaseDTO> purchaseList = new ArrayList<>();
	private Map<String, Object> session;
	public String execute() {
		if(session.get("userId")==null){
			return ERROR;
		}
		userId= (int) session.get("userId");
		LoginDAO dao = new LoginDAO();
		userList=dao.select(null, null,userId);
		PurchaseDAO pDao=new  PurchaseDAO();
		purchaseList = pDao.PurchaseSelect(userId);
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
	 * @return userList
	 */
	public List<UsersDTO> getUserList() {
		return userList;
	}
	/**
	 * @param userList セットする userList
	 */
	public void setUserList(List<UsersDTO> userList) {
		this.userList = userList;
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
	public List<PurchaseDTO> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(List<PurchaseDTO> purchaseList) {
		this.purchaseList = purchaseList;
	}


}
