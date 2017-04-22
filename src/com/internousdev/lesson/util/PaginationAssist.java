package com.internousdev.lesson.util;

public class PaginationAssist {

	/**
	 *  ページ数を格納する配列
	 */
	private int[] pageZ;

	/**
	 *   ページの最小数(1ページ)
	 */
	private int minPage;

	/**
	 *   表示するページネーションの数
	 */
	private final int  PAGINATION=10;

	public  int[] pagenation(int num,int maxPage){

		final int AROUNDPAGE=PAGINATION/2;
		maxPage = (int) Math.ceil((double) 140 / 6);
		minPage = Math.max(num - AROUNDPAGE, 1);
		if (maxPage < num + AROUNDPAGE && maxPage > AROUNDPAGE+1) {
			minPage = maxPage+1-PAGINATION;
		}
		int maxPagination = Math.min(PAGINATION, maxPage);
		pageZ = new int[maxPagination];
		for (int i = 0; i < maxPagination; i++) {
			pageZ[i] = minPage + i;
			System.out.println(i+1+"hh" + pageZ[i]);
		}
		return pageZ;
	}

}
