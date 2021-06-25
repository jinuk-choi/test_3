package com.test1.project.domain;

public class Board  {
	private int aIdx;
	private int uIdx;
	private int aCount;
	private int rownum;
	private String aTitle;
	private String aContent;
	private String aWriter;
	private String aDate;
	private User user;
	private int aGroup;
	private int aOrder;
	private int aDepth;
	
	
	
	
	public int getaIdx() {
		return aIdx;
	}
	public void setaIdx(int aIdx) {
		this.aIdx = aIdx;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getaWriter() {
		return aWriter;
	}
	public void setaWriter(String aWriter) {
		this.aWriter = aWriter;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public int getaGroup() {
		return aGroup;
	}
	public void setaGroup(int aGroup) {
		this.aGroup = aGroup;
	}
	public int getaOrder() {
		return aOrder;
	}
	public void setaOrder(int aOrder) {
		this.aOrder = aOrder;
	}
	public int getaDepth() {
		return aDepth;
	}
	public void setaDepth(int aDepth) {
		this.aDepth = aDepth;
	}
	
	public int getuIdx() {
		return uIdx;
	}
	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	
	public int getaCount() {
		return aCount;
	}
	public void setaCount(int aCount) {
		this.aCount = aCount;
	}
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	@Override
	public String toString() {
		return "Board [aIdx=" + aIdx + ", aTitle=" + aTitle + ", aContent=" + aContent + ", aWriter=" + aWriter
				+ ", aDate=" + aDate + ", user=" + user + ",  aGroup=" + aGroup
				+ ", aOrder=" + aOrder + ", aDepth=" + aDepth + "]";
	}
	
	
}
