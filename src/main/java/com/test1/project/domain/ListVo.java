package com.test1.project.domain;

public class ListVo {
	int aIdx;
	int pageNum;
	
	public ListVo() {
		
	}
	
	public ListVo(int aIdx, int pageNum) {
		this.aIdx = aIdx;
		this.pageNum = pageNum;
	}
	public int getaIdx() {
		return aIdx;
	}
	public void setaIdx(int aIdx) {
		this.aIdx = aIdx;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
