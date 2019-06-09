package org.mjmj.service;

import java.util.List;

import org.mjmj.domain.Criteria;
import org.mjmj.domain.ReplyVo;
import org.mjmj.mapper.replyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class replyService {
	
	@Setter(onMethod_ =@Autowired )
	private replyMapper mapper;

	public int register(ReplyVo vo) {
		log.info("댓글 등록 .. "+vo);
		return mapper.insert(vo);
	}
	
	public ReplyVo get(Long bno) {
		log.info("get!---"+bno);
		
		return mapper.read(bno);

	}
	public int modify(ReplyVo vo) {
		log.info("modify--"+vo);
		return mapper.update(vo);
	}
	
	public int remove(Long rno) {
		log.info("delete...");
		return mapper.delete(rno);
	}
	
	public List<ReplyVo> getList(Criteria cri,Long bno){
		log.info("list & paging");
		log.info(mapper.getListWithPaging(cri, bno));
		return mapper.getListWithPaging(cri, bno);
	}
	
	
}//replyService

