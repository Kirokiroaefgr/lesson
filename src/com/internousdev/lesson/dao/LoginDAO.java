package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.util.DBConnector;

/**
 * ログインするためにデータと照合するクラス
 *
 * @author KEIGO NISHIMORI
 *
 */
public class LoginDAO {

	/**
	 * ユーザーデータを取ってくるメソッド
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	public List<UsersDTO> select(String email, String password, int userId) {
		DBConnector db = new DBConnector("openconnect");
		List<UsersDTO> userList = new ArrayList<>();
		UsersDTO dto = new UsersDTO();
		String sql = "select * from users";
		if (userId != 0) {
			sql += " where user_id=?";
		} else if (email != null) {
			sql += " where phone_email=? and password=?";
		}
		try (Connection con = db.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				) {

			if (userId != 0) {
				ps.setInt(1, userId);
			} else if (email != null) {
				ps.setString(1, email);
				ps.setString(2, password);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto.setEmail(rs.getString("phone_email"));
				dto.setPassword(rs.getString("password"));
				dto.setUserId(rs.getInt("user_id"));
				dto.setLoginFlg(rs.getBoolean("login_flg"));
				dto.setFamilyNameKanji(rs.getString("family_name_kanji"));
				dto.setGivenNameKanji(rs.getString("given_name_kanji"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setGivenNameKana(rs.getString("given_name_kana"));
				dto.setAddress(rs.getString("address"));
				dto.setUserFlg(rs.getInt("user_flg"));
				dto.setSex(rs.getString("sex"));

				String bd = rs.getString("birthday");
				LocalDate ld = LocalDate.parse(bd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String bdld = ld.format(DateTimeFormatter.ofPattern("yyyy年MMMMd日(eeee)生まれ", Locale.JAPANESE));
				dto.setBirthday(bdld);

				String postal = rs.getString("postal");
				StringBuilder sb = new StringBuilder();
				sb.append(postal);
				sb.insert(0, "〒");
				sb.insert(4, "-");
				dto.setPostal(sb.toString());

				userList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * ユーザーのログインフラグをtrueにするメソッド
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	public int update(String email, String password) {
		int count = 0;
		DBConnector db = new DBConnector("openconnect");
		Connection con = db.getConnection();
		String sql = "update users set login_flg = true where phone_email = ? and password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
