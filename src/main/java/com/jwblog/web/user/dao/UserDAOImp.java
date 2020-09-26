package com.jwblog.web.user.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jwblog.web.user.model.UserVO;

@Repository
public class UserDAOImp implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override public List<UserVO> getUserList() throws Exception { 
		return sqlSession.selectList("com.jwblog.web.user.userMapper.getUserList"); 
		} 
	@Override public UserVO getUserInfo(String uid) throws Exception { 
		return sqlSession.selectOne("com.jwblog.web.user.userMapper.getUserInfo", uid); 
		} 
	@Override public int insertUser(UserVO userVO) throws Exception { 
		return sqlSession.insert("com.jwblog.web.user.userMapper.insertUser", userVO); 
		} 
	@Override public int updateUser(UserVO userVO) throws Exception { 
		return sqlSession.update("com.jwblog.web.user.userMapper.updateUser", userVO);
		} 
	@Override public int deleteUser(String uid) throws Exception { 
		return sqlSession.delete("com.jwblog.web.user.userMapper.deleteUser", uid); 
		} 
}
