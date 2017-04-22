package com.internousdev.lesson.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class LotInsert  extends ActionSupport {

	public String execute()  {
		int aa = 0;
		DBConnector db = new DBConnector("lesson");
		String sql = "insert into item (item_name,item_genre,item_Author,release_date,page,isbm,price,item_detail,item_img01,stock) values(?,?,'lesson',?,?,123,?,'asdgfhklafeaffaw','noImage.png',50)";
		try (Connection con = db.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			for(int i=0; i<200;i++){
				String ai="a"+i;
				String au="2017月"+i+"月";
				ps.setString(1, ai);
				if(i%2==0){
					ps.setString(2, "Ｊａｖａ");
				}else{
					ps.setString(2, "C言語");
				}
				ps.setString(3, au);
				ps.setInt(4, i);
				ps.setInt(5, (1+i)*100);
				aa+=ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(aa);
		return SUCCESS;
	}

}
