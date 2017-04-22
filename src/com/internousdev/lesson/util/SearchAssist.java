package com.internousdev.lesson.util;


public class SearchAssist {
	/**
	 * ページ数を格納する配列
	 */
	private int[] pageZ;

	/**
	 * ページの最小数(1ページ)
	 */
	private int minPage;

	/**
	 * 表示するページネーションの数 現在表示しているページとその前後4ページの合計ページを表示している。
	 */
	private final int PAGINATION = 9;

	public  int[] pagenation(int num,int countPagination){

		countPagination = (int) Math.ceil((double) 140 / 6);
		minPage = Math.max(num - 4, 1);
		if (countPagination < num + 4 && countPagination > 5) {
			minPage += countPagination - (num + 4);
		}
		int maxPagination = Math.min(PAGINATION, countPagination);
		pageZ = new int[maxPagination];
		for (int i = 0; i < maxPagination; i++) {
			pageZ[i] = minPage + i;
			System.out.println("hh" + pageZ[i]);
		}
		return pageZ;
	}

}
