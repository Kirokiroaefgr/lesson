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



/**
 * <P>カートに商品を登録するクラス<br>
 * ログインしてなかったとき、HashMapの「cartOrder」(商品のitemIDと注文数)を「cartOrderSession」というキー名でsessionにいれて保存している。<br>
 * ログインしていたとき、MySQLのcartテーブルに商品情報をinsertとupdateして保存している。 sessionは使っていない。<br>
 * また、sessionに「cartOrderSession」があって(つまりログインしてなかった)、ログインしたときに「cartOrderSession」の<br>
 * 情報を取り出してcartテーブルに商品情報をinsertかupdateして保存したあと「cartOrderSession」をsessionからremoveする。(ログインしたときかならず一回だけ実行する)</p>
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/05
 * @version 1.00
 **/
public class CartInsertAction extends CartAssist implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 2535821092269154907L;

	/**
	 * カート内に入ってる商品の合計金額
	 */
	private float payment;

	/**
	 * カート内に入ってる合計商品数
	 */
	private int order;

	/**
	 * 商品詳細からカートに画面遷移したとき
	 */
	private boolean isDetail;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品の注文数
	 */
	private int orderNumber;

	/**
	 * 検索したカート内の商品の情報を入れるリスト
	 */
	private List<CartDTO> cartList = new ArrayList<>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 注文数と商品の在庫数を計算した値をいれる
	 */
	private int totalNumber;

	List<CartDTO> msg= new ArrayList<>();

	/**
	 * [概 要] 戻り値の型に合わせてキャスト
	 * @return castObj
	 *  @param obj オブジェ
	 * @param <T> t
	 */
	@SuppressWarnings("unchecked")
	public static <T> T autoCast(Object obj) {
		T castObj = (T) obj;
		return castObj;
	}

	/**
	 * 実行メソッド
	 * カートに商品を入れるメソッド
	 * @return SUCCESS
	 * */
	public String execute() {
		// 商品のitemIDと注文数を入れるためのHashMap
		Map<Integer, Integer> cartOrder = new HashMap<>();
		// カート内にある商品をjspに表示するため または ログインしていた場合、カートテーブルに商品があるか調べる
		CartSelectDAO certDao = new CartSelectDAO();
		// ログインしていた場合mysqlにデータをinsert&update実行するためにCartUpdateDAOをインスタンス化
		CartUpdateDAO isInsert = new CartUpdateDAO();
		if (session.containsKey("cartOrderSession")) {// sessionにcartOrderSession(商品のitemIDと注文数が入ってる)が入っていたら
			cartOrder = autoCast(session.get("cartOrderSession"));
		}

		//▼▼ログインしてないときの処理 ここから▼▼
		if (!(session.containsKey("userId"))) {// ログインしてなかったらプログラム開始
			if (cartOrder.containsKey(itemId) && isDetail) {// 商品詳細からカートの遷移のとき
				this.totalNumber=totalNumber(cartOrder.get(itemId),orderNumber, itemId);
			} else if (orderNumber != 0) {
				this.totalNumber=totalNumber(0,orderNumber, itemId);
			}
			if (orderNumber != 0) {
				cartOrder.put(itemId, totalNumber);
				session.put("cartOrderSession", cartOrder);
				cartOrder = autoCast(session.get("cartOrderSession"));
			}
			if (session.containsKey("cartOrderSession")) {
				cartList = certDao.displayCart(cartOrder);
				this.order=totalOrder(cartList);
				this.payment=payment(cartList);
			}
			return SUCCESS;
		}
		//▲▲ログインしてないときの処理 ここまで▲▲

		userId = (int) session.get("userId");

		//▼▼ログインしたときセッション同期する処理(一回だけ) ここから▼▼
		if (!(session.containsKey("cartSync")) && session.containsKey("cartOrderSession")) {// 同期してないとき&&sessionに"cartOrderSession"がないとき
			for (Integer key : cartOrder.keySet()) {// cartOrderに入ってるキー数だけ繰り返す
				cartList = certDao.selectCart(userId, key, false);
				if (cartList.isEmpty()) {// カートテーブルになにもなかったら、データベースにinsert
					this.totalNumber=totalNumber(((int) cartOrder.get(key) ),0, key);
					isInsert.exeUpdate(userId, key, totalNumber, true);
				} else {// カートテーブル似合った場合、データベースにupdate
					this.totalNumber=totalNumber(((int) cartOrder.get(key)) + (cartList.get(0).getOrderCount()),0, key);
					isInsert.exeUpdate(userId, key, totalNumber, false);
				}
			}
			session.remove("cartOrderSession");//
			session.put("cartSync", "同期しました");
		}
		//▲▲ログインしたときセッション同期する処理(一回だけ) ここまで▲▲

		//▼▼ログインしてるときの処理 ここから▼▼
		if (orderNumber != 0) {// ログイン状態で同期関係なしに動きます。
			cartList = certDao.selectCart(userId, itemId, false);
			if (!(cartList.isEmpty()) && isDetail) { // 商品詳細からカートに行ったとき(update)
				this.totalNumber=totalNumber(cartList.get(0).getOrderCount(),orderNumber, itemId);
				isInsert.exeUpdate(userId, itemId, totalNumber, false);
			} else if (cartList.isEmpty()) { // カートテーブルになにも入ってないとき(insert)
				this.totalNumber=totalNumber(0, orderNumber,itemId);
				isInsert.exeUpdate(userId, itemId, totalNumber, true);
			} else { // カートテーブルに商品が入ってるとき(update)
				this.totalNumber=totalNumber(0,orderNumber, itemId);
				isInsert.exeUpdate(userId, itemId, totalNumber, false);
			}
		}
		cartList = certDao.selectCart(userId, itemId, true);
		this.msg=StockCheck(cartList, userId, 0);
		cartList = certDao.selectCart(userId, itemId, true);
		this.order=totalOrder(cartList);
		this.payment=payment(cartList);
		return SUCCESS;
		//▲▲ログインしてるときの処理 ここまで▲▲
	}

	/**
	 * カート内の合計金額を取得するためのメソッド
	 * @return payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 *  カート内の合計金額を格納するためのメソッド
	 * @param payment セットする payment
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * カート内の商品数を取得するためのメソッド
	 * @return order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * カート内の商品数を格納するためのメソッド
	 * @param order セットする order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 *  商品詳細からカートに画面遷移したときのためのメソッド
	 * @return isDetail
	 */
	public boolean isDetail() {
		return isDetail;
	}

	/**
	 * 商品詳細からカートに画面遷移したときのためのメソッド
	 * @param isDetail セットする isDetail
	 */
	public void setDetail(boolean isDetail) {
		this.isDetail = isDetail;
	}

	/**
	 *  ユーザーIDを取得するためのメソッド
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを格納するためのメソッド
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 商品Idを取得するためのメソッド
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 *  商品Idを格納するためのメソッド
	 * @param itemId セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品の注文数を取得するためのメソッド
	 * @return orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 商品の注文数を格納するためのメソッド
	 * @param orderNumber セットする orderNumber
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 検索したカート内の商品の情報を入れるリストを取得するためのメソッド
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
		return cartList;
	}

	/**
	 * 検索したカート内の商品の情報を入れるリストを格納するためのメソッド
	 * @param cartList セットする cartList
	 */
	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * セッションを取得するためのメソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを格納するためのメソッド
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 *  注文数と商品の在庫数を計算した値をいれるリストを取得するためのメソッド
	 * @return totalNumber
	 */
	public int getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 注文数と商品の在庫数を計算した値をいれるリストを格納するためのメソッド
	 * @param totalNumber セットする totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
