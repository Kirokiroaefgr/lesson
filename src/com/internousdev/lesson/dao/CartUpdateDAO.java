package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.lesson.dto.ItemDTO;
import com.internousdev.util.DBConnector;

/**
 * カートインサート＆アップデート用クラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/21
 * @version 1.0
 */
public class CartUpdateDAO {

	/**cartテーブルにinsertまたはupdateするためのメソッド
	 * @param userId 顧客番号
	 * @param itemId 商品番号
	 * @param orderNumber 注文番号
	 * @param isInsert インサート
	 */
	public void exeUpdate(int userId, int itemId, int orderNumber, boolean isInsert) {
		DBConnector db = new DBConnector("lesson");
		try (Connection con = db.getConnection();
				PreparedStatement ps = createPreparedStatement(con, userId, itemId, orderNumber, isInsert);) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**PreparedStatementに値をセットして返すメソッド
	 * @param con
	 * @param userId
	 * @param itemId
	 * @param orderNumber
	 * @param isInsert
	 * @return Ps
	 * @throws SQLException
	 */
	private PreparedStatement createPreparedStatement(Connection con, int userId, int itemId, int orderNumber,
			boolean isInsert) throws SQLException {
		ItemListDAO itemDao = new ItemListDAO();
		List<ItemDTO> item = itemDao.itemSelect(null,itemId,0,0);
		String sql;
		if (isInsert) {
			sql = "insert into cart (order_count,user_id,item_id,item_name,subtotal,item_Img01) values (?,?,?,?,?,?)";
		} else {
			sql = "update cart set order_count=? where user_id=? and item_id=?" ;
		}

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, orderNumber);
		ps.setInt(2, userId);
		ps.setInt(3, itemId);
		if (isInsert) {
			ps.setString(4, item.get(0).getItemName());
			ps.setFloat(5, item.get(0).getPrice());
			ps.setString(6, item.get(0).getItemImg01());
		}
		return ps;
	}

}
