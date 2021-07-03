package com.test1.project.contoller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test1.project.domain.Board;
import com.test1.project.domain.Comment;
import com.test1.project.domain.ListVo;
import com.test1.project.domain.Pagination;
import com.test1.project.domain.Search;
import com.test1.project.service.BoardService;
import com.test1.project.service.CommentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping({"/user","/user/{pageOpt}"})
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  userAccess(@PathVariable Optional<Integer> pageOpt) {
		Search search = null;
		int count = 0;
		int page = pageOpt.isPresent() ? pageOpt.get() : 1;
		
		Pagination<Board> pagination = new Pagination<Board>();
		List<Board> boardList = null;
		
		
		
		count = boardService.countBoard(search);
		pagination = new Pagination<Board>(page,count);
		boardList = boardService.selectBoardList(pagination);
		pagination.setList(boardList);
		
		return ResponseEntity.ok(pagination);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('Admin')")
	public String adminAccess() {
		return "Admin Content.";
	}
	
	@GetMapping("/boardDetail")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDetail(@RequestParam int aIdx, Board board) {
		boardService.count(board);
		logger.info("///"+aIdx);
		
		board = boardService.selectBoardDetail(aIdx);
		return ResponseEntity.ok(board);
	}
	
	@DeleteMapping("/boardDelete/{aIdx}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "aIdx") int aIdx) {
		boardService.deleteBoard(aIdx);
		logger.info("delete"+aIdx);
		
		
		return ResponseEntity.ok(aIdx);
	}
	
	@PostMapping("/boardWrite")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardWrite(@RequestBody Board board) {
		boardService.insertBoard(board);
		logger.info("Write"+board);
		
		
		return ResponseEntity.ok(board);
	}
	
	@PostMapping("/boardEdit")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardEdit(@RequestBody Board board) {
		boardService.editBoard(board);
		logger.info("Edit"+board);
		
		
		return ResponseEntity.ok(board);
	}
	
	@GetMapping({"/commentList","/commentList/{pageOpt}"})
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  commentList(@PathVariable Optional<Integer> pageOpt
									     ,@RequestParam int aIdx
										 ,Board board) {
		
		int count = 0;
		int page = pageOpt.isPresent() ? pageOpt.get() : 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(board);
		pagination = new Pagination<Comment>(page,count);
		
		pageNum = pagination.getPageNum();
		listvo = new ListVo(aIdx,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		return ResponseEntity.ok(pagination);
	}
	
	@DeleteMapping("/commentDelete/{bIdx}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  commentDelete(@PathVariable(value = "bIdx") int bIdx,
											@RequestParam int aIdx,
											Board board) {
		commentService.commentDelete(bIdx);
		
		int count = 0;
		int page = 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(board);
		pagination = new Pagination<Comment>(page,count);
		pageNum = pagination.getPageNum();
		listvo = new ListVo(aIdx,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		
		return ResponseEntity.ok(pagination);
	}
	
	@PostMapping("/commentWrite")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  commentWrite(@RequestBody Comment comment) {
		commentService.insertComment(comment);
		logger.info("Write"+comment);
		
		
		return ResponseEntity.ok(comment);
	}
	
	@PostMapping("/commentEdit")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  commentEdit(@RequestBody Comment comment) {
		commentService.editComment(comment);
		logger.info("Edit"+comment);
		
		
		return ResponseEntity.ok(comment);
	}
	
	
	
	

}
