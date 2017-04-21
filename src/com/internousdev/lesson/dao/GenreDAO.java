package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.lesson.dto.GenreDTO;
import com.internousdev.util.DBConnector;




public class GenreDAO {
	public ArrayList<GenreDTO> selectGenre() {
		DBConnector db = new DBConnector("lesson");
		Connection con = db.getConnection();
		ArrayList<GenreDTO> genreList = new ArrayList<GenreDTO>();
		String sql = "SELECT * FROM genre";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GenreDTO dto = new GenreDTO();
				dto.setGenreId(rs.getInt("genre_id"));
				dto.setItemGenre(rs.getString("item_genre"));
				dto.setRegistrationDate(rs.getString("registration_date"));
				dto.setRegistrationDate(rs.getString("updated_date"));
				genreList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genreList;
	}

}
