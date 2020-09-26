package com.jwblog.web.user.dao;

import java.util.List;

import com.jwblog.web.user.model.UserVO;

public interface UserDAO {
	public List<UserVO> getUserList() throws Exception; 
	public UserVO getUserInfo(String uid) throws Exception; 
	public int insertUser(UserVO userVO) throws Exception; 
	public int updateUser(UserVO userVO) throws Exception; 
	public int deleteUser(String uid) throws Exception;
}
