package org.mjmj.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mjmj.domain.Criteria;
import org.mjmj.domain.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {org.mjmj.config.RootConfig.class})
@Log4j
public class replyMapperTests {
	@Setter(onMethod_ = @Autowired)
	private replyMapper mapper;
	@Test
	public void testMapper() {
		log.info(mapper);
		
	}
	private long[] bnoArr = {61L,62L,63L,64L,65L,66L,67L,68L,69L,70L};
	@Test
	public void testCreate() {
	
		IntStream.range(1, 10).forEach(i ->{
			ReplyVo vo = new ReplyVo();
			vo.setBno(bnoArr[i]);
			vo.setReply("가라가라댓글"+i);
			vo.setReplyer("밍듀"+i);
			
			mapper.insert(vo);
		});
		
	}//testCreate
	
	@Test
	public void restRead() {
		
		Long targetRno = 62L;
		
		ReplyVo vo = mapper.read(targetRno);
		log.info("read test -- "+vo);
		
	}
	@Test
	public void testDelete() {
		
		Long targetRno = 10L;
		mapper.delete(targetRno);
	}
	@Test
	public void testUpdate() {
		
		Long targetBno = 62L;
		ReplyVo vo = mapper.read(targetBno);
		vo.setReply("박재범의 원리");
		int count = mapper.update(vo);
		log.info("update count :"+count);
		
		
	}
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVo> replies = mapper.getListWithPaging(cri, bnoArr[3]);
		
		replies.forEach(reply -> log.info(reply));
	}
	

}//replyMapperTests
