package com.test1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test1.project.domain.Board;
import com.test1.project.domain.Pagination;
import com.test1.project.domain.Search;



@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int aIdx);
	
	public void deleteBoard(int aIdx);
	
	public int countBoard(Search search);
}
