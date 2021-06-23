package com.test1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test1.project.domain.Board;



@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	
	public Board selectBoardDetail(int aIdx);
	
	public void deleteBoard(int aIdx);
}
