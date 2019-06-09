package org.mjmj.mapper;

import java.util.List;

import org.mjmj.domain.BoardVO;
import org.mjmj.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from book_ex where bno > 0") 
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	//public void insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri); 
	public int getTotalCount(Criteria cri);
	
	
}
