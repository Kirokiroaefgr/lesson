package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.LoginDAO;
import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.lesson.util.LotInsert;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログインするためのクラス
 *
 * @author keigo nishimori
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 7766584779295909596L;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザーID
	 */
	private int userId;
	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * エラーメッセージ
	 */
	private String errorMsg;

	/**
	 * 実行メソッド DAOにログイン情報を渡して結果を返す
	 *
	 * @author keigo nishimori
	 * @return result 入力された情報がDBと照合に成功したらSUCCESS 失敗したらERROR
	 */
	public String execute() {
		LoginDAO dao = new LoginDAO();
		List<UsersDTO> userList = new ArrayList<>();
		userList = dao.select(email, password,0);
		LotInsert insert=new LotInsert();
		insert.li();

		if (userList.size() == 0) {
			errorMsg = "パスワードまたはメールアドレスが間違っています。";
			return ERROR;
		}

		if (userList.get(0).isLoginFlg() != false) {
			errorMsg = "すでにログインされています。";
			return ERROR;
		}

		if (dao.update(userList.get(0).getEmail(), userList.get(0).getPassword()) == 0) {
			errorMsg="エラーのためもう一度お願いします。";
			return ERROR;
		}

		userId = userList.get(0).getUserId();
		session.put("userId", userId);
		session.put("name", userList.get(0).getFamilyNameKanji()+userList.get(0).getGivenNameKanji());
		return SUCCESS;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg セットする errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}