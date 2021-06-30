package com.test1.project.service;

import java.util.List;

import com.test1.project.domain.Board;
import com.test1.project.domain.Pagination;
import com.test1.project.domain.Search;




public interface BoardService {
	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int aIdx);
	
	public void deleteBoard(int aIdx);
	
	public int countBoard(Search search);
	
	public void insertBoard(Board board);
	
	public void editBoard(Board board);
	
	public int count(Board board);
}
