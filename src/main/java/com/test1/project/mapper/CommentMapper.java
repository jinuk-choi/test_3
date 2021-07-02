package com.test1.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.test1.project.domain.Board;
import com.test1.project.domain.Comment;
import com.test1.project.domain.ListVo;


@Mapper
public interface CommentMapper {
	public List<Comment> selectCommentList(ListVo listvo);

	public int commentCount(Board board);
	
	public void insertComment(Comment comment);
	
	public void commentDelete(int bIdx);
	
	public void editComment(Comment comment);
	
	public void updateComment(Comment comment);
	
	public void updateReComment(Comment comment);

}
