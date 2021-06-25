package com.test1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.project.domain.Board;
import com.test1.project.domain.Pagination;
import com.test1.project.domain.Search;
import com.test1.project.mapper.BoardMapper;




@Service("BoardServiceImple")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList(Pagination pagination) {
		return boardMapper.selectBoardList(pagination);
	}


	@Override
	public Board selectBoardDetail(int aIdx) {
		return boardMapper.selectBoardDetail(aIdx);
	}
	
	@Override
	public void deleteBoard(int aIdx){
		boardMapper.deleteBoard(aIdx);
	}
	
	
	public int countBoard(Search search) {
		return boardMapper.countBoard(search);
	}

}
