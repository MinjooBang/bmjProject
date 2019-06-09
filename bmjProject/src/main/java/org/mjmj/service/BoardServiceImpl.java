package org.mjmj.service;

import java.util.List;

import org.mjmj.domain.BoardVO;
import org.mjmj.domain.Criteria;
import org.mjmj.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	@Override
	public boolean delete(long bno) {
		log.info("delete....."+bno);
		return mapper.delete(bno) == 1;
	}

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	
	@Override
	public void register(BoardVO board) {
		log.info("register..........."+board);
		mapper.insert(board);
		
	}
	

	@Override
	public BoardVO get(long bno) {
		
		log.info("get()......");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify.........."+board);
		
		return mapper.update(board) == 1;
	}

	/*@Override
	public List<BoardVO> getList() {
		log.info("getList()......");
		
		return mapper.getList();
	}*/


	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List paging with criteria "+cri);
		
		return mapper.getListWithPaging(cri);
	}


	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}


	

	
	

}
