package org.mjmj.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
	org.mjmj.config.RootConfig.class,
	org.mjmj.config.ServletConfig.class
})
@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = {@Autowired} )
	private WebApplicationContext ctx;

	//���̴�.. 
	private MockMvc mockmvc;
	
	@Before
	public void setup() {
		
		this.mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}//setup
	
	
	@Test
	public void testList() throws Exception{
		log.info(
				mockmvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
		
	}//testList
	@Test
	public void testRegister() throws Exception{
		
		String resultPage = mockmvc.perform(MockMvcRequestBuilders.post("/board/register")
							.param("title", "��..�����Ѱ� ����")
							.param("contents", "�̰� �Ķ��� �ۿ� �ִ� �� �ȿ� �ִ� ����...")
							.param("writer", "������ �ε�")
							).andReturn().getModelAndView().getViewName();
		
		
		log.info(resultPage);
						
		
	}//testRegister
	
	@Test
	public void testGet() throws Exception{
		
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn().getModelAndView());
		
	}//testGet
	
	@Test
	public void testModify() throws Exception {
		
		String resultpage = mockmvc.
							perform(MockMvcRequestBuilders.post("/board/modify")
									.param("bno", "9")
									.param("title","�̷��̷�")
									.param("contents", "�տ� �ڲ� ���� ����.. ���� ������ �ȵǴµ�...")
									.param("writer","������ �ε�")
								   ).andReturn().getModelAndView().getViewName();
		
		log.info(resultpage);
		
	}//testModify
	
	@Test
	public void testDelete() throws Exception{
		
		String resultPage = mockmvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno","10")).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}//testDelete
	
	@Test
	public  void  testListPaging() throws Exception {
		
		log.info("testListPaging"+
				mockmvc.perform(MockMvcRequestBuilders.get("/board/list").param("pagenum","3").param("amount", "5"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}
	
}//BoardControllerTests
