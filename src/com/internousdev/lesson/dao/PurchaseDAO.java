package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
					String purchaseDate=rs.getString("purchase_date");
					LocalDateTime ld = LocalDateTime.parse(purchaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n"));
					String pld =ld.format(DateTimeFormatter.ofPattern("yyyy年MMMMd日hh時mm分", Locale.JAPANESE));
					dto.setPurchaseDate(pld);
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
