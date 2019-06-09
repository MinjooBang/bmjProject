package org.mjmj.mapper;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mjmj.domain.BoardVO;
import org.mjmj.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.mjmj.config.RootConfig.class})
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRead() {
		log.info("������ �ϴ�..?");
		BoardVO board = mapper.read(2L);
		
		log.info(board);
		
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("�μ�Ʈ");
		board.setContents("�װ� �ƴ϶� �ȵǴϱ�..");
		board.setWriter("�� �ϳ��� ������ �ʴ°ǵ�..");
		
		//mapper.insert(board);
		//log.info(board);
		
	}
	@Test
	public void testDelete() {
		
		//log.info("delete count : "+mapper.delete(7L));
		
	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setTitle("��θ�");
		board.setContents("Ȳ���ָ���..���ζ��..�̰Ŷ��.");
		board.setWriter("�ȶ��� �ε�");
		board.setBno(3L);
		
		int count = mapper.update(board);
		log.info("update count" + count);
		
	}
	
	
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		cri.setPagenum(2);
		cri.setAmount(5);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info("paging -"+board));
		
	}

	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("일요일");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info("서취 테스트 :"+board));
		
	}




}//BoardMapperTest

