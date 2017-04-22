package com.internousdev.lesson.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionSupport {

	/**
	 * コミットします。
	 * @param con コネクション
	 */
	public void commit(Connection con) {
		if (con != null) {
			try {
			  con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ロールバックします。
	 * @param con コネクション
	 */
	public void rollback(Connection con) {
		if (con != null) {
			try {
			  con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * コネクションをクローズします。
	 * @param con コネクション
	 */
	public void closeCon(Connection con) {
		if (con != null) {
			try {
			  con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ステートメントをクローズします。
	 * @param ps ps
	 */
	public void closePs(PreparedStatement ps) {
		if (ps != null) {
			try {
			  ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 結果セットをクローズします。
	 * @param rs リザルト
	 */
	public void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
			  rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
