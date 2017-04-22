package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.lesson.dto.CartDTO;
import com.internousdev.lesson.util.ConnectionSupport;
import com.internousdev.util.DBConnector;

/**
 * cartテーブルにある商品情報を削除するクラス
 *
 * @author KEIGO NISHIMORI
 *  @since 2017/04/21
 * @version 1.0
 */
public class CartDeleteDAO extends ConnectionSupport {

	/**
	 * mysqlのcetusに接続
	 */
	Connection con = new DBConnector("lesson").getConnection();

	/**
	 * SQL文を表すオブジェクト
	 */
	PreparedStatement ps = null;
	/**
	 * cartテーブルにある商品情報を削除するメソッド
	 *
	 * @param userId 顧客情報
	 * @param itemId 商品番号
	 * @throws SQLException ＳＱＬ
	 */
	public void delete(int userId, int itemId) throws SQLException {
		con.setAutoCommit(false);
		String sql = "delete from cart where user_id = ?";
		if (itemId != 0) {
			sql += " " + "&& item_id= ?";
		}
			ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			if (itemId != 0) {
			ps.setInt(2, itemId);
			}
			ps.executeUpdate();
	}

	/**決済が完了した注文数分 在庫を減らす処理をするメソッド
	 * @param cartList カート内リスト
	 * @throws SQLException ＳＱＬ
	 */
	public void itemUpdate(List<CartDTO> cartList) throws SQLException {
		con.setAutoCommit(false);
		String sql = "update item set stock = stock - ? where item_id=?";
			for (CartDTO cart : cartList) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getOrderCount());
				ps.setInt(2, cart.getItemId());
				ps.executeUpdate();
			}
	}

	/**
	 * commitとcloseを実行するメソッド
	 */
	public void itemComit(){
		commit(con);
		closePs(ps);
		closeCon(con);
	}

	/**
	 * rollbackとcloseを実行するメソッド
	 */
	public void itemRollBack(){
		rollback(con);
		closePs(ps);
		closeCon(con);
	}
}
