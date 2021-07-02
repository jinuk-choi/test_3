package com.test1.project.service;

import java.util.List;

import com.test1.project.domain.Board;
import com.test1.project.domain.Comment;
import com.test1.project.domain.ListVo;

public interface CommentService {
	public List<Comment> selectCommentList(ListVo listvo);

	public int commentCount(Board board);
	
	public void insertComment(Comment comment);
	
	public void editComment(Comment comment);
	
	public void commentDelete(int bIdx);

}
