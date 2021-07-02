package com.test1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test1.project.domain.Board;
import com.test1.project.domain.Comment;
import com.test1.project.domain.ListVo;
import com.test1.project.mapper.CommentMapper;


@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired CommentMapper commentmapper;
	
	@Override
	public List<Comment> selectCommentList(ListVo listvo) {
		return commentmapper.selectCommentList(listvo);
	}
	
	@Override
	public int commentCount(Board board) {
		return commentmapper.commentCount(board);
	}
	
	@Override
	public void insertComment(Comment comment) {
		commentmapper.insertComment(comment);
		
		if (comment.getbGroup() == 0) {
			commentmapper.updateComment(comment);
		
		} else { 
			commentmapper.updateReComment(comment);
		}
	}
	
	@Override
	public void commentDelete(int bIdx) {
		commentmapper.commentDelete(bIdx);
	}
	
	@Override
	public void editComment(Comment comment) {
		commentmapper.editComment(comment);
	}

}
