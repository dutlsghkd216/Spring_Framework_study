package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> getList(Criteria criteria);
	public void insert(BoardVO baord);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO baord);
	public int getTotal(Criteria criteria);
}
