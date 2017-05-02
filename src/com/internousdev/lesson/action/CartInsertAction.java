package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.lesson.dao.CartSelectDAO;
import com.internousdev.lesson.dao.CartUpdateDAO;
import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.util.CartAssist;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <P>
 * カートに商品を登録するクラス<br>
 * ログインしてなかったとき、HashMapの「cartOrder」(商品のitemIDと注文数)を「cartOrderSession」というキー名でsessionにいれて保存している。<br>
 * ログインしていたとき、MySQLのcartテーブルに商品情報をinsertとupdateして保存している。 sessionは使っていない。<br>
 * また、sessionに「cartOrderSession」があって(つまりログインしてなかった)、ログインしたときに「cartOrderSession」の<br>
 * 情報を取り出してcartテーブルに商品情報をinsertかupdateして保存したあと「cartOrderSession」をsessionからremoveする。(ログインしたときかならず一回だけ実行する)
 * </p>
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/05
 * @version 1.00
 **/
public class CartInsertAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2535821092269154907L;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * カート内に入ってる商品の合計金額
	 */
	private float payment;

	/**
	 * カート内に入ってる合計商品数
	 */
	private int totalOrders;

	/**
	 * 商品の注文数
	 */
	private int NumberOfOrders;

	/**
	 * 注文数と商品の在庫数を比較した最終注文数の値をいれる
	 */
	private int FirmOrderNumber;

	/**
	 * 商品詳細からカートに画面遷移したとき
	 */
	private boolean isDetail;

	/**
	 * 検索したカート内の商品の情報を入れるリスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();

	/**
	 * カートに入ってる商品が在庫0になった場合、カートテーブルから削除してその商品名を格納するリスト
	 */
	private List<CartDTO> msg = new ArrayList<>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * [概 要] 戻り値の型に合わせてキャスト
	 *
	 * @return castObj
	 * @param obj
	 *            オブジェクト
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T autoCast(Object obj) {
		T castObj = (T) obj;
		return castObj;
	}

	/**
	 * 実行メソッド カートに商品を入れるメソッド
	 *
	 * @return SUCCESS
	 */
	public String execute() {

		//cartの在庫チェック・合計注文数などを処理するクラスをインスタンス化
		CartAssist assist=new CartAssist();

		// 商品のitemIDと注文数を入れるためのHashMap
		Map<Integer, Integer> cartSession = new HashMap<>();

		// カート内にある商品をjspに表示するため または ログインしていた場合、カートテーブルに商品があるか調べる
		CartSelectDAO certDao = new CartSelectDAO();

		// ログインしていた場合mysqlにデータをinsert&update実行するためにCartUpdateDAOをインスタンス化
		CartUpdateDAO isInsert = new CartUpdateDAO();

		if (session.containsKey("cartSession")) {// sessionにcartSession(商品のitemIDと注文数が入ってる)が入っていたら
			cartSession = autoCast(session.get("cartSession"));
		}

		// ▼▼ログインしてないときの処理 ここから▼▼
		if (!(session.containsKey("userId"))) {// ログインしていなかったら

			//▽▽cartSessionに商品名と注文数を追加する処理 ここから▽▽
			if (cartSession.containsKey(itemId)&& isDetail) {//cartSessionにitemIdがあったら
				this.FirmOrderNumber = assist.FirmOrderNumber(cartSession.get(itemId), NumberOfOrders, itemId);
			} else if (NumberOfOrders != 0) {//注文数が0個以外だったら
				this.FirmOrderNumber = assist.FirmOrderNumber(0, NumberOfOrders, itemId);
			}

			if (NumberOfOrders != 0) {//注文数が0個以外だったら
				cartSession.put(itemId, FirmOrderNumber);
				session.put("cartSession", cartSession);
				cartSession = autoCast(session.get("cartSession"));
			}
			//△△cartSessionに商品名と注文数を追加する処理 ここまで△△

			//▽▽cart.jspにカートに入れた商品を表示する処理 ここから▽▽
			if (session.containsKey("cartSession")) {//cartSessionがあったら
				cartList = certDao.displayCart(cartSession);
				this.totalOrders=assist.totalOrders(cartList);
				this.payment=assist.payment(cartList);
			}
			//△△cart.jspにカートに入れた商品を表示する処理 ここまで△△

			return SUCCESS;
		}
		// ▲▲ログインしてないときの処理 ここまで▲▲


		//▼▼ログインしてるときの処理 ここから▼▼


		userId = (int) session.get("userId");

		//▽▽ログインしたときセッション同期する処理(一回だけ) ここから▽▽
		if (!(session.containsKey("cartSync")) && session.containsKey("cartSession")) {// 同期してないとき&&sessionに"cartSession"があるとき
			for (Integer key : cartSession.keySet()) {// cartOrderに入ってるキー数だけ繰り返す
				cartList = certDao.selectCart(userId, key, false);
				if (cartList.isEmpty()) {// カートテーブルになにもなかったら、データベースに(insert)
					this.FirmOrderNumber=assist.FirmOrderNumber(((int)cartSession.get(key) ),0, key);
					isInsert.exeUpdate(userId, key, FirmOrderNumber, true);
				} else {// カートテーブル似合った場合、データベースに(update)
					this.FirmOrderNumber=assist.FirmOrderNumber(((int) cartSession.get(key)) + (cartList.get(0).getOrderCount()),0, key);
					isInsert.exeUpdate(userId, key, FirmOrderNumber, false);
				}
			}
			session.remove("cartSession");
			session.put("cartSync", "同期しました");
		}
		//△△ログインしたときセッション同期する処理(一回だけ) ここまで△△


		//▽▽cartテーブルに注文数をinsertまたはupdateする処理 ここから▽▽
		if (NumberOfOrders != 0) {//
			cartList = certDao.selectCart(userId, itemId, false);
			if (cartList.size() != 0 && isDetail) { // カートテーブルに商品がなかったら&商品詳細からカートに行ったとき(update)
				this.FirmOrderNumber=assist.FirmOrderNumber(cartList.get(0).getOrderCount(),NumberOfOrders, itemId);
				isInsert.exeUpdate(userId, itemId, FirmOrderNumber, false);
			} else if (cartList.isEmpty()) { // カートテーブルになにも入ってないとき(insert)
				this.FirmOrderNumber=assist.FirmOrderNumber(0, NumberOfOrders,itemId);
				isInsert.exeUpdate(userId, itemId, FirmOrderNumber, true);
			} else { // カートテーブルに商品が入ってるとき(update)
				this.FirmOrderNumber=assist.FirmOrderNumber(0,NumberOfOrders, itemId);
				isInsert.exeUpdate(userId, itemId, FirmOrderNumber, false);
			}
		}
		//△△cartテーブルに注文数をinsertまたはupdateする処理 ここまで△△


		//▽▽cart.jspにカートに入れた商品を表示する処理 ここから▽▽
		cartList = certDao.selectCart(userId, itemId, true);
		this.msg=assist.StockCheck(cartList, userId, 0);
		cartList = certDao.selectCart(userId, itemId, true);
		this.totalOrders=assist.totalOrders(cartList);
		this.payment=assist.payment(cartList);
		//△△cart.jspにカートに入れた商品を表示する処理 ここまで△△


		return SUCCESS;
		//▲▲ログインしてるときの処理 ここまで▲▲

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
	 * @return payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 * @param payment セットする payment
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * @return totalOrders
	 */
	public int getTotalOrders() {
		return totalOrders;
	}

	/**
	 * @param totalOrders セットする totalOrders
	 */
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	/**
	 * @return numberOfOrders
	 */
	public int getNumberOfOrders() {
		return NumberOfOrders;
	}

	/**
	 * @param numberOfOrders セットする numberOfOrders
	 */
	public void setNumberOfOrders(int numberOfOrders) {
		NumberOfOrders = numberOfOrders;
	}

	/**
	 * @return firmOrderNumber
	 */
	public int getFirmOrderNumber() {
		return FirmOrderNumber;
	}

	/**
	 * @param firmOrderNumber セットする firmOrderNumber
	 */
	public void setFirmOrderNumber(int firmOrderNumber) {
		FirmOrderNumber = firmOrderNumber;
	}

	/**
	 * @return isDetail
	 */
	public boolean isDetail() {
		return isDetail;
	}

	/**
	 * @param isDetail セットする isDetail
	 */
	public void setDetail(boolean isDetail) {
		this.isDetail = isDetail;
	}

	/**
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * @return msg
	 */
	public List<CartDTO> getMsg() {
		return msg;
	}

	/**
	 * @param msg セットする msg
	 */
	public void setMsg(List<CartDTO> msg) {
		this.msg = msg;
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
