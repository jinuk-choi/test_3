package com.test1.project.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String username;
	private String name;
	private int uIdx;
	private List<String> roles;
	private String type = "Bearer";
	
	public JwtResponse(String jwt, String id, String u_name, int uIdx, List<String> u_roles) {
		this.token = jwt;
		this.username = id;
		this.name = u_name;
		this.roles = u_roles;
		this.uIdx = uIdx;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getType() {
		return type;
	}
	
	public int getuIdx() {
		return uIdx;
	}
	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", name=" + name + ", roles=" + roles + "]";
	}
		
}
