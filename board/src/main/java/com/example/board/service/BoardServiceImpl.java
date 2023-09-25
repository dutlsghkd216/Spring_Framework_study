package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	// 게시글 등록
	@Override
	public void register(BoardVO board) {
		boardDAO.register(board);
	}

	// 게시글 보기(한건)
	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	}

	// 게시글 수정하기
	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board);
	}

	// 게시글 삭제하기
	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	}

	//게시글 전체 조회
	@Override
	public List<BoardVO> getList() {
		return boardDAO.getList();
	}

}
