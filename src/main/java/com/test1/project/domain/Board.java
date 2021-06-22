package com.test1.project.domain;

public class Board {
	private int aIdx;
	private String aTitle;
	private String aContent;
	private String aWriter;
	private String aDate;
	
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
	@Override
	public String toString() {
		return "Board [aIdx=" + aIdx + ", aTitle=" + aTitle + ", aContent=" + aContent + ", aWriter=" + aWriter
				+ ", aDate=" + aDate + "]";
	}
	
	
}
