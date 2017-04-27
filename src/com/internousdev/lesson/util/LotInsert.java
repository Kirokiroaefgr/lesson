package com.internousdev.lesson.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.DBConnector;

public class LotInsert {

	public void li() {
		String[] genre = { "Ｊａｖａ", "C言語", "データベース", "資格関連" };
		int aa = 0;
		DBConnector db = new DBConnector("lesson");
		String sql = "insert into item (item_name,item_genre,item_author,release_date,page,isbm,price,item_detail,item_img01,stock) values(?,?,'lesson',?,?,'123-123',?,'特になし。','noImage.png',50)";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			for (int i = 0; i < genre.length; i++) {
				for (int j = 0; j < 100; j++) {
					String au = "2017月" + j + "月";
					ps.setString(1, genre[i]+j);
					ps.setString(2, genre[i]);
					ps.setString(3, au);
					ps.setInt(4, i);
					ps.setInt(5, (1 + j) * 100);
					aa += ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(aa);
	}

}
