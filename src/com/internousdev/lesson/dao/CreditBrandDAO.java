package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.lesson.dto.UsersDTO;
import com.internousdev.util.DBConnector;

     /** クレジットカード情報を照合するクラス
	 * @author KEIGO NISHIMORI
	 * @since 2017/04/10
	 * @version 1.0
	 */
public class CreditBrandDAO {

	/**クレジットカードの種類を確認するメソッド
	 * @param creditBrand クレジットの種類
	 * @param checkNumber 登録番号
	 * @return true or false
	 */
	public boolean select(int creditBrand, String checkNumber) {
		DBConnector db = new DBConnector("creditcard_manager");
		Connection con = db.getConnection();
		String result = null;
		if(creditBrand == 1){
			result = "Visa";
		}else if(creditBrand == 2){
			result = "MasterCard";
		}else if(creditBrand == 3){
			result = "American Express";
		}
		String sql = "SELECT * FROM m_creditcard_type WHERE card_number = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, checkNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("card_name").equals(result)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * クレジットカード会社のデータベースからユーザーの情報を取得するメソッド
	 * @author KEIGO NISHIMORI
	 * @since 2017/04/07
	 * @version 1.0
	 * @param creditBrand クレジットの種類
	 * @param creditNumber クレジット番号
	 * @param securityCode セキュリティーコード
	 * @return dto
	 */
	public UsersDTO selectUserInfo(int creditBrand, String creditNumber,String securityCode){
		Connection con=null;
		UsersDTO dto = new UsersDTO();
		String brandName = null;
		if(creditBrand == 1){
			brandName = "visa";
		}else if(creditBrand == 2){
			brandName = "mastercard";
		}else if(creditBrand == 3){
			brandName = "americanexpress";
		}
		DBConnector db = new DBConnector(brandName);
		con= db.getConnection();
		String sql = "SELECT * FROM credit_card WHERE credit_number = ? and security_code=?" ;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,creditNumber);
			ps.setString(2, securityCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(brandName == "visa"){
					dto.setUserId(rs.getInt("security_code"));
					dto.setPassword(rs.getString("login_id"));
					dto.setFamilyName(rs.getString("last_name"));
					dto.setGivenName(rs.getString("first_name"));
				}else{
					dto.setPassword(rs.getString("login_id"));
					dto.setGivenName(rs.getString("name_e"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return dto;

	}

}
