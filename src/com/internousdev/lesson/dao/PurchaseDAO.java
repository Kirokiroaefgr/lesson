package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dto.PurchaseDTO;
import com.internousdev.util.DBConnector;

public class PurchaseDAO {
		/**
		 * 購入履歴を表示するメソッド
		 *
		 * @author KEIGO NISHIMORI
		 * @param userId 顧客番号
		 * @return dto
		 */
		public List<PurchaseDTO> PurchaseSelect(int userId) {
			DBConnector db = new DBConnector("lesson");
			Connection con = db.getConnection();
			PurchaseDTO dto = new PurchaseDTO();
			List<PurchaseDTO> purchaseDtoList = new ArrayList<PurchaseDTO>();
			PreparedStatement ps = null;
			String sql = "SELECT * FROM purchase WHERE user_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					dto = new PurchaseDTO();
					dto.setPurchaseDate(rs.getString("purchase_date"));
					dto.setItemName(rs.getString("item_name"));
					dto.setOrderCount(rs.getInt("order_count"));
					dto.setSubtotal(rs.getInt("subtotal"));
					purchaseDtoList.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return purchaseDtoList;
		}
}
