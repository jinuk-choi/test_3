package com.test1.project.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import com.test1.project.domain.User;
import com.test1.project.domain.UserInfo;

@Mapper
public interface UserMapper {
	//유저읽기
		public User readUser(String username);
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username);
	//유저권한읽기 새로고침
		public List<GrantedAuthority>  readAuthorities_refresh(String username);
	
	 //유저생성
		public void createUser(User user);
//	 // 유저목록 불러오기
//		public List<UserInfo> readUserList();
	//
		public List<UserInfo>read_user_list();
//	//유저목록 권한 불러오기
//		public List<UserInfo>  readAuthorities_all();
	 // 권한 읽기
		public List<GrantedAuthority> readAuthorities(String username);
	 // 권한 생성
		public void createAuthority(User user);
}
