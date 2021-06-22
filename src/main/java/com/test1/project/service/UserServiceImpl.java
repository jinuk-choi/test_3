package com.test1.project.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test1.project.domain.User;
import com.test1.project.domain.UserInfo;
import com.test1.project.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println(username);
		User user = userMapper.readUser(username);
		user.setAuthorities(getAuthorities(username));	
		return user;
	}


	@Override
	public User readUser(String username) {
		return userMapper.readUser(username);
	}


	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authorities = userMapper.readAuthorities(username);
		return authorities;
	}

	 @Override
	   public void createUser(User user) {
	      userMapper.createUser(user);
	   }

	@Override
	public void createAuthority(User user) {
		userMapper.createAuthority(user);
	}
	
	@Override
	public List<UserInfo>read_user_list() {
		return userMapper.read_user_list();
	}
	
//	@Override
//	public List<UserInfo> readUserList() {
//		return userMapper.readUserList();
//	}
//	//유저목록 권한 불러오기
//		public List<UserInfo>  readAuthorities_all() {
//			return userMapper.readAuthorities_all();
//		}
	
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username) {
			return userMapper.readUser_refresh(username);
		}
	//유저권한읽기 새로고침
		public List<GrantedAuthority> readAuthorities_refresh(String username) {
			return userMapper.readAuthorities_refresh(username);
		}
}
