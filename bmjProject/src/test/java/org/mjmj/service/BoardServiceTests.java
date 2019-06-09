package org.mjmj.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mjmj.domain.BoardVO;
import org.mjmj.domain.Criteria;
import org.mjmj.mapper.BoardMapper;
import org.mjmj.mapper.BoardMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.mjmj.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
		
	}
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("6�ù̿��");
		board.setContents("���������� �Ҳ��� ����ϴϱ�...���¾� ��ο�ο��");
		board.setWriter("����Ͽ� ����ִ�");
		
		//service.register(board);
		log.info("������ �� �Խù��� ��ȣ : "+board.getBno());
	}
	
	@Test
	public void testGetlist() {
		//service.getList().forEach(board -> log.info(board));
		
		service.getList(new Criteria(2,10)).forEach(board -> log.info("board paging -"+board));
	}
	
	
	@Test
	public void testGet() {
		log.info(service.get(8L));
	}
	
	@Test
	public void testDelete() {
		log.info("Remove Result : "+service.delete(1L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(8L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("�Ͽ��Ͽ����ϴٴ�....�̷�..");
		log.info("modify result : "+service.modify(board));
	}
	
	
	
	
	
	

}//BoardServiceTests

