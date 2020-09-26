package com.jwblog.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwblog.web.board.dao.BoardDAO;
import com.jwblog.web.board.model.BoardVO;
import com.jwblog.web.board.model.ReplyVO;
import com.jwblog.web.common.Pagination;
import com.jwblog.web.common.Search;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO boardDAO;
	
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return boardDAO.getBoardList(search);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardDAO.updateViewCnt(bid);
		boardVO = boardDAO.getBoardContent(bid);
		
		//Cate_cd에 컬럼에서 저장할 수 있는 크기보다 큰 문자열 저장
		//수정 SQL문 처리시 문제 발생
//		boardVO.setBid(bid);
//		boardVO.setCate_cd("1111111111111111111111111111111111111");
//		boardDAO.updateBoard(boardVO);
		return boardVO;
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}
	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}
	//댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int bid) throws Exception {
		return boardDAO.getReplyList(bid);
	}
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return boardDAO.saveReply(replyVO);
	}
	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return boardDAO.updateReply(replyVO);
	}
	@Override
	public int deleteReply(int rid) throws Exception {
		return boardDAO.deleteReply(rid);
	}
}
