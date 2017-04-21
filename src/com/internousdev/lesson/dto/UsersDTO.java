
package com.internousdev.lesson.dto;


/**
 * 顧客情報を格納するためのDTOクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/20
 * @version 1.0
 */
public class UsersDTO {
	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 姓(アルファベット)
	 */
	private String familyName;

	/**
	 * 名(アルファベット)
	 */
	private String givenName;

	/**
	 * 姓(漢字)
	 */
	private String familyNameKanji;

	/**
	 * 姓(ふりがな)
	 */
	private String familyNameKana;

	/**
	 * 名(漢字)
	 */
	private String givenNameKanji;

	/**
	 * 名(ふりがな)
	 */
	private String givenNameKana;

	/**
	 * 郵便番号
	 */
	private String postal;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 電話番号
	 */
	private String phoneNumber;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * 携帯電話番号
	 */
	private String mobileNumber;

	/**
	 * 携帯メールアドレス
	 */
	private String mobileEmail;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * 生年月日
	 */
	private String birthday;

	/**
	 * 退会フラグ
	 */
	private boolean userdelFlg;

	/**
	 * ログインフラグ
	 */
	private boolean loginFlg;

	/**
	 * ユーザーフラグ
	 */
	private int userFlg;

	/**
	 * 受講年
	 */
	private String year;

	/**
	 * 受講月
	 */
	private String month;

	/**
	 * OauthID
	 */
	private String oauthId;

	/**
	 * Oauth名
	 */
	private int oauthName;

	/**
	 * Oauthアカウント
	 */
	private String oauthAccount;

	/**
	 * 登録日
	 */
	private String registerDay;

	/**
	 * 更新日
	 */
	private String updateDay;



	/**
	 * ユーザーID取得メソッド
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * ユーザーID格納メソッド
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * パスワード取得メソッド
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * パスワード格納メソッド
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 姓（アルファベット）取得メソッド
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 姓（アルファベット）格納メソッド
	 * @param familyName セットする familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	/**
	 * 名（アルファベット）取得メソッド
	 * @return givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * 名（アルファベット）格納メソッド
	 * @param givenName セットする givenName
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * 姓（漢字）取得メソッド
	 * @return familyNameKanji
	 */
	public String getFamilyNameKanji() {
		return familyNameKanji;
	}
	/**
	 * 姓（漢字）格納メソッド
	 * @param familyNameKanji セットする familyNameKanji
	 */
	public void setFamilyNameKanji(String familyNameKanji) {
		this.familyNameKanji = familyNameKanji;
	}
	/**
	 * 姓（カタカナ）取得メソッド
	 * @return familyNameKana
	 */
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	/**
	 * 姓（カタカナ）格納メソッド
	 * @param familyNameKana セットする familyNameKana
	 */
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	/**
	 * 名（漢字）取得メソッド
	 * @return givenNameKanji
	 */
	public String getGivenNameKanji() {
		return givenNameKanji;
	}
	/**
	 * 名（漢字）格納メソッド
	 * @param givenNameKanji セットする givenNameKanji
	 */
	public void setGivenNameKanji(String givenNameKanji) {
		this.givenNameKanji = givenNameKanji;
	}
	/**
	 * 名（カタカナ）取得メソッド
	 * @return givenNameKana
	 */
	public String getGivenNameKana() {
		return givenNameKana;
	}
	/**
	 * 名（カタカナ）格納メソッド
	 * @param givenNameKana セットする givenNameKana
	 */
	public void setGivenNameKana(String givenNameKana) {
		this.givenNameKana = givenNameKana;
	}
	/**
	 * 郵便番号取得メソッド
	 * @return postal
	 */
	public String getPostal() {
		return postal;
	}
	/**
	 * 郵便番号格納メソッド
	 * @param postal セットする postal
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
	/**
	 * 住所取得メソッド
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 住所格納メソッド
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 電話番号取得メソッド
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 電話番号格納メソッド
	 * @param phoneNumber セットする phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * メールアドレス取得メソッド
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * メールアドレス格納メソッド
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 携帯電話番号取得メソッド
	 * @return mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * 携帯電話番号格納メソッド
	 * @param mobileNumber セットする mobileNumber
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * 携帯メールアドレス取得メソッド
	 * @return mobileEmail
	 */
	public String getMobileEmail() {
		return mobileEmail;
	}
	/**
	 * 携帯メールアドレス格納メソッド
	 * @param mobileEmail セットする mobileEmail
	 */
	public void setMobileEmail(String mobileEmail) {
		this.mobileEmail = mobileEmail;
	}
	/**
	 * 性別取得メソッド
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 性別格納メソッド
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 誕生日取得メソッド
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 誕生日格納メソッド
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * デリートフラグ取得メソッド
	 * @return userdelFlg
	 */
	public boolean isUserdelFlg() {
		return userdelFlg;
	}
	/**
	 * デリートフラグ格納メソッド
	 * @param userdelFlg セットする userdelFlg
	 */
	public void setUserdelFlg(boolean userdelFlg) {
		this.userdelFlg = userdelFlg;
	}
	/**
	 * ログインフラグ取得メソッド
	 * @return loginFlg
	 */
	public boolean isLoginFlg() {
		return loginFlg;
	}
	/**
	 * ログインフラグ格納メソッド
	 * @param loginFlg セットする loginFlg
	 */
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	/**
	 * ユーザーフラグ取得メソッド
	 * @return userFlg
	 */
	public int getUserFlg() {
		return userFlg;
	}
	/**
	 * ユーザーフラグ格納メソッド
	 * @param userFlg セットする userFlg
	 */
	public void setUserFlg(int userFlg) {
		this.userFlg = userFlg;
	}
	/**
	 * 受講年取得メソッド
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 受講年格納メソッド
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 受講月取得メソッド
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 受講月格納メソッド
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * oauthID取得メソッド
	 * @return oauthId
	 */
	public String getOauthId() {
		return oauthId;
	}
	/**
	 * oauthID格納メソッド
	 * @param oauthId セットする oauthId
	 */
	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}
	/**
	 * oauth名取得メソッド
	 * @return oauthName
	 */
	public int getOauthName() {
		return oauthName;
	}
	/**
	 * oauth名格納メソッド
	 * @param oauthName セットする oauthName
	 */
	public void setOauthName(int oauthName) {
		this.oauthName = oauthName;
	}
	/**
	 * oauthアカウント取得メソッド
	 * @return oauthAccount
	 */
	public String getOauthAccount() {
		return oauthAccount;
	}
	/**
	 * oauthアカウント格納
	 * @param oauthAccount セットする oauthAccount
	 */
	public void setOauthAccount(String oauthAccount) {
		this.oauthAccount = oauthAccount;
	}
	/**
	 * 登録日取得メソッド
	 * @return registerDay
	 */
	public String getRegisterDay() {
		return registerDay;
	}
	/**
	 * 登録日格納メソッド
	 * @param registerDay セットする registerDay
	 */
	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}
	/**
	 * 更新日取得メソッド
	 * @return updateDay
	 */
	public String getUpdateDay() {
		return updateDay;
	}
	/**
	 * 更新日格納メソッド
	 * @param updateDay セットする updateDay
	 */
	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}

}