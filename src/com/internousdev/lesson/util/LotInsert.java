package com.internousdev.lesson.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.internousdev.util.DBConnector;

public class LotInsert {

	public void li() {
		String[] genre = { "Ｊａｖａ", "C言語", "データベース", "資格関連" };
		int aa = 0;
		Random rand = new Random();
		DBConnector db = new DBConnector("lesson");
		String sql = "insert into item (item_name,item_genre,item_author,release_date,page,isbm,price,item_detail,item_img01,stock) values(?,?,'lesson',?,?,'123-123',?,'特になし。','noImage.png',50)";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			for (int i = 0; i < genre.length; i++) {
				for (int j = 1; j <= 100; j++) {
					int num = rand.nextInt(12)+1;
					String au = "2016月" + num + "月";
					ps.setString(1, genre[i]+j);
					ps.setString(2, genre[i]);
					ps.setString(3, au);
					ps.setInt(4, i);
					ps.setInt(5, j * 100);
					aa += ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(aa);
	}

}
