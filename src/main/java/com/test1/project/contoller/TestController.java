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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test1.project.domain.Board;
import com.test1.project.domain.Pagination;
import com.test1.project.domain.Search;
import com.test1.project.service.BoardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping({"/user","/user/{pageOpt}"})
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  userAccess(@PathVariable Optional<Integer> pageOpt) {
		Pagination<Board> pagination = new Pagination<Board>();
		List<Board> boardList = null;
		
		Search search = null;
		int count = 0;
		int page = pageOpt.isPresent() ? pageOpt.get() : 1;
		
		count = boardService.countBoard(search);
		pagination = new Pagination<Board>(page,count);
		boardList = boardService.selectBoardList(pagination);
		pagination.setBoardList(boardList);
		
		return ResponseEntity.ok(pagination);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('Admin')")
	public String adminAccess() {
		return "Admin Content.";
	}
	
	@GetMapping("/boardDetail")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDetail(@RequestParam int aIdx) {
		
		logger.info("///"+aIdx);
		
		Board board = boardService.selectBoardDetail(aIdx);
		return ResponseEntity.ok(board);
	}
	
	@DeleteMapping("/boardDelete/{aIdx}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "aIdx") int aIdx) {
		
		logger.info("delete"+aIdx);
		boardService.deleteBoard(aIdx);
	
		return ResponseEntity.ok(aIdx);
	}
	

}
