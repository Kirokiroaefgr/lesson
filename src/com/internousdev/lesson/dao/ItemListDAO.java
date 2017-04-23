package com.internousdev.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dto.ItemDTO;
import com.internousdev.util.DBConnector;

/**
 * 商品を一覧表示とソート機能を実現するためのクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/21
 */
public class ItemListDAO {
	private int pageNum;
	private int amountSearch;
	private int amountSort;

	public ItemListDAO() {
	}

	public ItemListDAO(int pageNum, int amountSearch, int amountSort) {
		this.pageNum = pageNum;
		this.amountSearch = amountSearch;
		this.amountSort = amountSort;
	}

	/**
	 * 商品一覧画面において、検索したDBから抽出するメソッド
	 *
	 * @param itemGenre
	 *            商品カテゴリ
	 * @return searchList
	 */
	public List<ItemDTO> itemSelect(String itemGenre, int itemId) {
		DBConnector db = new DBConnector("lesson");
		List<ItemDTO> itemList = new ArrayList<>();
		String sql = "SELECT * FROM item";

		if (this.amountSearch != 0) {
			if (itemGenre != null) {
				sql = "select * from item where item_genre=? and";
			} else {
				sql = "select * from item where";
			}

			switch (this.amountSearch) {
			case 1:
				sql += " price>=0 and price<=1000";
				break;
			case 2:
				sql += " price>=1001 and price<=2000";
				break;
			case 3:
				sql += " price>=2001 and price<=5000";
				break;
			case 4:
				sql += " price>=5001";
				break;
			}
		} else if (itemGenre != null) {
			sql = "SELECT * FROM item WHERE item_genre = ?";
		} else if (itemId != 0) {
			sql = "SELECT * FROM item where item_id=?";
		}

		if (this.amountSort == 1) {
			sql += " order by price desc";
		} else if (this.amountSort == 2) {
			sql += " order by price";
		}
		if (itemId == 0) {
			sql += " limit ?,12";
		}

		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			if (itemGenre != null) {
				ps.setString(1, itemGenre);
				ps.setInt(2, this.pageNum);
			} else if (itemId != 0) {
				ps.setInt(1, itemId);
			} else {
				ps.setInt(1, this.pageNum);
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));// 商品ID
				dto.setItemName(rs.getString("item_name"));// 商品名
				dto.setItemGenre(rs.getString("item_genre"));// 商品ジャンル
				dto.setItemAuthor(rs.getString("item_author"));// 著者
				dto.setReleaseDate(rs.getString("release_date"));// 発売日
				dto.setPage(rs.getInt("page"));// 商品のページ数
				dto.setPrice(rs.getFloat("price"));// 値段
				dto.setIsbm(rs.getString("isbm"));//
				dto.setItemDetail(rs.getString("item_detail"));// 商品詳細
				dto.setItemImg01(rs.getString("item_img01"));// 画像01
				dto.setItemImg02(rs.getString("item_img02"));// 画像02
				dto.setItemImg03(rs.getString("item_img03"));// 画像03
				dto.setStock(rs.getInt("stock"));// 在庫
				dto.setRegistrationDate(rs.getString("registration_date"));// 商品登録日
				itemList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	public int countSelect(String itemGenre) {
		int count = 0;
		DBConnector db = new DBConnector("lesson");
		String sql = "select count(item_genre) from item";

		if (this.amountSearch != 0) {
			if (itemGenre != null) {
				sql = "select count(item_genre) from item where item_genre=? and";
			} else {
				sql = "select count(item_genre) from item where";
			}
			switch (this.amountSearch) {
			case 1:
				sql += " price>=0 and price<=1000";
				break;
			case 2:
				sql += " price>=1001 and price<=2000";
				break;
			case 3:
				sql += " price>=2001 and price<=5000";
				break;
			case 4:
				sql += " price>=5001";
				break;
			}
		} else if (itemGenre != null) {
			sql += " where item_genre=?";
		}
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			if (itemGenre != null) {
				ps.setString(1, itemGenre);
			}
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
