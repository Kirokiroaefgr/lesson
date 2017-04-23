package com.internousdev.lesson.util;

public class PaginationAssist {

	/**
	 *  ページ数を格納する配列
	 */
	private int[] page;

	/**
	 *   ページの最小数(1ページ)
	 */
	private int minPage;

	/**
	 *   表示するページネーションの数
	 */
	private final int  PAGINATION=10;

	public  int[] pagenation(int pageNum,int maxPage){
		final int AROUNDPAGE=PAGINATION/2;
		minPage = Math.max(pageNum - AROUNDPAGE, 1);
		if (maxPage < pageNum + AROUNDPAGE && maxPage > AROUNDPAGE+1) {
			minPage = Math.max((maxPage+1-PAGINATION),1);
		}
		int maxPagination = Math.min(PAGINATION, maxPage);
		page = new int[maxPagination];
		for (int i = 0; i < maxPagination; i++) {
			page[i] = minPage + i;
		}
		return page;
	}

}
