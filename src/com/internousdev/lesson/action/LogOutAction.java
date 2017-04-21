package com.internousdev.lesson.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.LogoutDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログアウト処理をするクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/20
 * @version 1.0
 */
public class LogOutAction extends ActionSupport implements SessionAware {

	/**
	 * SessionAware用
	 */
	private Map<String, Object> session;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * ログインフラグ
	 */
	private boolean login;

	/**
	 * 実行メソッド
	 */
	public String execute() throws SQLException {
		LogoutDAO dao = new LogoutDAO();

		if (session.get("userId") == null) {
			return ERROR;
		}

		userId = (int) session.get("userId");
		dao.update(userId);
		session.clear();
		return SUCCESS;

	}

	/**
	 * @return session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return login
	 */
	public boolean isLogin() {
		return login;
	}

	/**
	 * @param login
	 *            セットする login
	 */
	public void setLogin(boolean login) {
		this.login = login;
	}

}
