package com.test1.project.domain;

import java.util.List;

public class Pagination<T> {
	int count;       // user테이블에 등록 된 총 user 수
	int cocount;	// comment 수
	int page;           // 현재 패이지번호
	int pageNum;          // userCount / page = 화면에 나타 낼 user index번호
	int startPage;     //﻿ pagination의 시작(ex,1,6,11)
	int endPage;      // ﻿pagination의 끝(ex,5,10,15)
	int lastPage;     // (userCount/화면에 표시할 갯수), pagination 마지막 번호
	int prevPage;     // pagination의 이전 목록
	int nextPage;     // pagination의 다음 목록
	public static final int pageUnit=5;  // 한번에 불러 올 pagination 수
	public static final int perPage=5;   // 한번에 불러 올 userCount 수
	Search search;
	List<T> list;
	

	
	
	public Pagination() {
		
	}
	
	public Pagination(int page, int count) {
		this(page, count, null);
	}
	
	public Pagination(int page, int count, Search search) {
		this.page = page;
		this.count = count;
		this.search = search;
		this.pageNum = (page-1)*perPage;
		
		startPage =((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int)Math.ceil(count / (float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage=(startPage-1);
		nextPage=(startPage+pageUnit);
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCocount() {
		return cocount;
	}

	public void setCocount(int cocount) {
		this.cocount = cocount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public int getPerPage() {
		return perPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}



}