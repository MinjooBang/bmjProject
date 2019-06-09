package org.mjmj.controller;

import java.util.List;

import org.mjmj.domain.Criteria;
import org.mjmj.domain.ReplyVo;
import org.mjmj.service.replyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private replyService service;
	
	@PostMapping(value="/new",consumes = "application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVo vo){
		
		log.info("replyvo -- "+vo);
		
		int insertCount = service.register(vo);
		
		return insertCount == 1 ? new ResponseEntity<>("sucess",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping(value="/page/{bno}/{page}", produces = {
			MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE
	})
	public ResponseEntity<List<ReplyVo>> getList(@PathVariable("page")int page,@PathVariable("bno")Long bno){
		
		log.info("getList...");
		Criteria cri = new Criteria(page,10);
		log.info(cri);
		
		return new ResponseEntity<>(service.getList(cri, bno),HttpStatus.OK);
		
		
	}
	
	@GetMapping(value = "/{bno}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVo> get(@PathVariable("bno")Long bno){
		log.info("get : "+bno);
		return new ResponseEntity<>(service.get(bno),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{rno}",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno")Long rno){
		
		log.info("remove : "+rno);
		
		return service.remove(rno) == 1 ?  new ResponseEntity<> ("success" ,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.PATCH},value="/{rno}",consumes = "application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVo vo, @PathVariable("rno") Long rno){
		
		vo.setRno(rno);
		
		log.info("rno :"+rno);
		log.info("modify :"+vo);
		return service.modify(vo)==1 ? new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
