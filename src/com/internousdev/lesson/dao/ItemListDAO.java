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
 * 商品を一覧表示するためのクラス
 *
 * @author KEIGO NISHIMORI
 * @since 2017/04/21
 */
public class ItemListDAO {
	/**
	 * 商品一覧画面において、検索したDBから抽出するメソッド
	 *
	 * @param itemGenre
	 *            商品カテゴリ
	 * @return searchList
	 */
	public List<ItemDTO> itemSelect(String itemGenre,int itemId) {
		DBConnector db  = new  DBConnector("lesson");
		List<ItemDTO> itemList = new ArrayList<>();
		String sql="SELECT * FROM item";
		if(itemGenre!=null){
			sql +=" WHERE item_genre = ?";
		}else if(itemId!=0){
			sql +=" where item_id=?";
		}
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			if(itemGenre!=null){
				ps.setString(1, itemGenre);
			}else if(itemId!=0){
				ps.setInt(1, itemId);
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
}
