package com.jwblog.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jwblog.web.board.model.BoardVO;
import com.jwblog.web.board.model.ReplyVO;
import com.jwblog.web.common.Search;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		System.out.println("키워드:"+search.getKeyword());
		return sqlSession.selectList("com.jwblog.web.board.boardMapper.getBoardList", search);
	}
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		return sqlSession.selectOne("com.jwblog.web.board.boardMapper.getBoardContent", bid);
	}
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("com.jwblog.web.board.boardMapper.insertBoard", boardVO);
	}
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("com.jwblog.web.board.boardMapper.updateBoard", boardVO);
	}
	@Override
	public int deleteBoard(int bid) throws Exception {
		return sqlSession.delete("com.jwblog.web.board.boardMapper.deleteBoard", bid);
	}
	@Override
	public int updateViewCnt(int bid) throws Exception {
		return sqlSession.update("com.jwblog.web.board.boardMapper.updateViewCnt", bid);
	}
	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("com.jwblog.web.board.boardMapper.getBoardListCnt", search);
	}
	//댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int bid) throws Exception {
		return sqlSession.selectList("com.jwblog.web.board.replyMapper.getReplyList", bid);
	}
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return sqlSession.insert("com.jwblog.web.board.replyMapper.saveReply", replyVO);
	}
	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return sqlSession.update("com.jwblog.web.board.replyMapper.updateReply", replyVO);
	}
	@Override
	public int deleteReply(int rid) throws Exception {
		return sqlSession.delete("com.freehoon.web.board.replyMapper.deleteReply", rid);
	}
}
