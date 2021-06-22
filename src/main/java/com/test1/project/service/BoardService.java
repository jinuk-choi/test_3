package com.test1.project.service;

import java.util.List;

import com.test1.project.domain.Board;




public interface BoardService {
	public List<Board> selectBoardList();
	
	public Board selectBoardDetail(int bId);
	
	public void deleteBoard(int bId);
}
