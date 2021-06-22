package com.test1.project.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.test1.project.domain.User;
import com.test1.project.domain.UserInfo;


public interface UserService extends UserDetailsService{
	//유저읽기
		public User readUser(String username);
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username);
	//유저권한읽기 새로고침
		public List<GrantedAuthority>  readAuthorities_refresh(String username);
	//유저생성
		public void createUser(User user);

//	// 유저목록 불러오기
//	   public List<UserInfo> readUserList();
//	 //유저목록 권한 불러오기
//	 		public List<UserInfo>  readAuthorities_all();
	   public List<UserInfo>read_user_list();
	// 시큐리티 권한 얻기
	   	Collection<GrantedAuthority> getAuthorities(String username);

	// 권한 생성
	   	public void createAuthority(User user);

}
