package com.internousdev.lesson.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.lesson.dto.UsersDTO;

public class Oooiu {

	public static void main(String[] args) {
		List<UsersDTO> list = new ArrayList<>();
		UsersDTO users = new UsersDTO();
		for (int i = 0; i < 40; i++) {
			users.setUserId(i);
			list.add(users);
		}
		System.out.println("合計ページ数"+(int) Math.ceil((double) 140 / 6));
		int pageNum = (int) Math.ceil((double) 140/ 6);
		int[] page = new int[pageNum];
		for (int i = 0; i < pageNum; i++) {
			page[i] = i + 1;
		}
		int jsp = 18;
		int ss = 0;

		ss = Math.max(jsp - 10, 1);
		if (pageNum < jsp + 10 && pageNum > 11) {
			ss += pageNum - (jsp + 10);
		}
		int lol = Math.min(21, pageNum);
		int[] pageZ = new int[lol];
		for (int i = 0; i < lol; i++) {
			pageZ[i] = ss + i;
			System.out.println("hh" + pageZ[i]);
		}
		System.out.println(pageZ.length);
	}

}
