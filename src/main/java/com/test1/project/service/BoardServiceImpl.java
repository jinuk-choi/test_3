package com.test1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.project.domain.Board;
import com.test1.project.mapper.BoardMapper;




@Service("BoardServiceImple")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList() {
		return boardMapper.selectBoardList();
	}


	@Override
	public Board selectBoardDetail(int bId) {
		return boardMapper.selectBoardDetail(bId);
	}
	
	@Override
	public void deleteBoard(int bId){
		boardMapper.deleteBoard(bId);
	}

}
