package org.mjmj.service;

import java.util.List;

import org.mjmj.domain.BoardVO;
import org.mjmj.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	public BoardVO get(long bno);
	public boolean modify(BoardVO board);
	//public List<BoardVO> getList();
	public boolean delete(long bno);
	public List<BoardVO> getList(Criteria cri) ;
	public int getTotal(Criteria cri);

}
