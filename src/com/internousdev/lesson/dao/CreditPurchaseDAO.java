package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.lesson.util.ConnectionSupport;
import com.internousdev.util.DBConnector;

/**
 * 購入履歴インサートするクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/10
 * @version 1.0
 */
public class CreditPurchaseDAO extends ConnectionSupport {

	/**
	 * mysqlのcetusに接続
	 */
	Connection cetusCon = new DBConnector("lesson").getConnection();

	/**
	 * mysqlのvisa,mastercard,americanexpressいずれかに接続
	 */
	Connection creditCon = null;

	/**
	 *  SQL文を表すオブジェクト
	 */
	PreparedStatement ps1 = null;

	/**
	 *  SQL文を表すオブジェクト
	 */
	PreparedStatement ps = null;

	public CreditPurchaseDAO(int creditBrand) {
		String brandName = null;
		if (creditBrand == 1) {
			brandName = "visa";
		} else if (creditBrand == 2) {
			brandName = "mastercard";
		} else if (creditBrand == 3) {
			brandName = "americanexpress";
		}
		this.creditCon = new DBConnector(brandName).getConnection();
	}


	/**
	 * クレジットカード会社に購入履歴をインサートするメソッド
	 *
	 * @param dto ＤＴＯ
	 * @param creditBrand クレジットの種類
	 * @param cartList カートリスト
	 * @throws SQLException ＳＱＬ
	 */
	public void CreditPurchaseHistory(UsersDTO dto, int creditBrand, List<CartDTO> cartList) throws SQLException {
		int payment = 0;
		for (CartDTO cart : cartList) {
			payment += cart.getSubtotal() * cart.getOrderCount();
		}
		String sql = "insert into user_history(login_id, corporation_name, spend, payment, name_e) values (?,  'lesson', ?, ?, ?)";
		if (creditBrand == 1) {
			sql = "insert into user_history(login_id, office_name, spend, payment, last_name, first_name) values (?, 'lesson', ?, ?, ?, ?)";
		}
		ps1 = creditCon.prepareStatement(sql);
		creditCon.setAutoCommit(false);
		ps1.setString(1, dto.getPassword());
		ps1.setInt(2, payment);
		ps1.setInt(3, payment);
		ps1.setString(4, dto.getGivenName());
		if (creditBrand == 1) {
			ps1.setString(5, dto.getFamilyName());
		}
		ps1.executeUpdate();
	}

	/**
	 * cetusに購入履歴をインサートするメソッド
	 *
	 * @param userId ユーザー番号
	 * @param creditBrand クレジットの種類
	 * @param shippingAddress お届け先
	 * @param cartList カートリスト
	 * @throws SQLException ＳＱＬ
	 */
	public void CetusPurchaseHistory(int userId, int creditBrand, String shippingAddress, List<CartDTO> cartList)
			throws SQLException {
		String sql = "INSERT INTO purchase(user_id, item_id, item_name, order_count, subtotal, payment_method, shipping_address) VALUES(?, ?, ?, ?, ?, ?, ?)";
		cetusCon.setAutoCommit(false);
		for (int i = 0; i < cartList.size(); i++) {
			ps = cetusCon.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, cartList.get(i).getItemId());
			ps.setString(3, cartList.get(i).getItemName());
			ps.setInt(4, cartList.get(i).getOrderCount());
			ps.setFloat(5, cartList.get(i).getOrderCount() * cartList.get(i).getSubtotal());
			ps.setInt(6, creditBrand);
			ps.setString(7, shippingAddress);
			ps.executeUpdate();
		}

	}

	/**
	 * commitとcloseを実行するメソッド
	 */
	public void commit() {
		commit(cetusCon);
		commit(creditCon);
		closePs(ps1);
		closePs(ps);
		closeCon(cetusCon);
		closeCon(creditCon);
	}

	/**
	 * rollbackとcloseを実行するメソッド
	 */
	public void rollback() {
		rollback(cetusCon);
		rollback(creditCon);
		closePs(ps1);
		closePs(ps);
		closeCon(cetusCon);
		closeCon(creditCon);
	}

}
