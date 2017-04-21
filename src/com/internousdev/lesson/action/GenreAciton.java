package com.internousdev.lesson.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dao.GenreDAO;
import com.internousdev.lesson.dto.GenreDTO;
import com.opensymphony.xwork2.ActionSupport;



public class GenreAciton extends ActionSupport {
	List<GenreDTO> genreList = new ArrayList<>();

	public String execute() {
		GenreDAO dao= new GenreDAO();
		genreList = dao.selectGenre();
		return SUCCESS;

	}

	/**
	 * @return genreList
	 */
	public List<GenreDTO> getGenreList() {
		return genreList;
	}

	/**
	 * @param genreList セットする genreList
	 */
	public void setGenreList(List<GenreDTO> genreList) {
		this.genreList = genreList;
	}

}
