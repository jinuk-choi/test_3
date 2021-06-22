package com.test1.project.contoller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test1.project.config.JwtUtils;
import com.test1.project.domain.Board;
import com.test1.project.domain.User;
import com.test1.project.domain.UserInfo;
import com.test1.project.request.JoinRequest;
import com.test1.project.request.LoginRequest;
import com.test1.project.response.JwtResponse;
import com.test1.project.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
		
		logger.info("test" + loginRequest);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		User user = (User) authentication.getPrincipal();		
		logger.info("dddd" + authentication.getPrincipal()); 
		List<String> roles = user.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 user.getUsername(), 
												 user.getName(),  
												 roles));
	}
	@PostMapping("/signup")
	   public ResponseEntity<?> sinupUser(@Validated @RequestBody JoinRequest joinRequest) {
		
	      String encodedPassword = new BCryptPasswordEncoder().encode(joinRequest.getPassword());
	      
	      User user = new User();
	      
	      //유저 데이터 세팅
	      user.setUsername(joinRequest.getUsername());
	      user.setName(joinRequest.getName());
	      user.setPassword(encodedPassword);
	      user.setAccountNonExpired(true);
	      user.setEnabled(true);
	      user.setAccountNonLocked(true);
	      user.setCredentialsNonExpired(true);
	      user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
	      
	      //유저 생성
	      userService.createUser(user);
	      //유저 권한 생성
	      userService.createAuthority(user);
	      
	      return new ResponseEntity<>("success", HttpStatus.OK);
	   }
	
	@GetMapping("/unpackToken")
	public ResponseEntity<?> unpackToken(HttpServletRequest request) {
		String token = new String();
		token =  request.getHeader("Authorization");
		
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			token =  token.substring(7, token.length());
		}
		String username = jwtUtils.getUserEmailFromToken(token);
		UserInfo user = userService.readUser_refresh(username);

		user.setAuthorities(userService.readAuthorities_refresh(username));
//		user.setAuthorities(userService.readAuthorities_refresh(username));
		 return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
}
