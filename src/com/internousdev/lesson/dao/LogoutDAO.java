package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.DBConnector;

/**
 * ユーザーをログアウトさせるためのDAOクラス
 * @author KEIGO NISHIMORI
 * @since 2017/04/20
 * @version 1.0
 */
public class LogoutDAO {

	/**
	 * ログアウトするユーザーのlogin_flgをfalseにするクラス
	 * @param userId 顧客番号
	 * @return count login_flgをUPDATEした数
	 */
	public int update(int userId) {
		int count = 0;

		DBConnector db = new DBConnector("openconnect");
		Connection con = db.getConnection();
		String sql = "UPDATE users SET login_flg = false WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
