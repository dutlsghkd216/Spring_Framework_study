package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	// 게시글 등록
	@Override
	public void register(BoardVO board) {
		boardMapper.insert(board);
	}

	// 게시글 보기(한건)
	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	// 게시글 수정하기
	@Override
	public boolean modify(BoardVO board) {
		return boardMapper.update(board) != 0;
	}

	// 게시글 삭제하기
	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) != 0;
	}

	//게시글 전체 조회
	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

}
