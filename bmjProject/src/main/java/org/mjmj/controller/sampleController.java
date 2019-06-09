package org.mjmj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.mjmj.domain.SampleVo;
import org.mjmj.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class sampleController {
	@GetMapping(value="/getText",produces= "text/plain;charset=UTF-8")
	public String getText() {
		log.info("MINE TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세여";
		
	}
	@GetMapping(value = "/getSample",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVo getSample(){
		return new SampleVo(112,"가오갤","스타로드하투하투");
	}
	@GetMapping(value = "/getSample2")
	public SampleVo getSample2(){
		return new SampleVo(112,"귀여운 로켓 그리고 그루투투투투","뚜루두루뚜루루루루");
	}
	@GetMapping(value="/getlist")
	public List<SampleVo> getList(){
		return IntStream.range(1,10).mapToObj(i -> new SampleVo(i,i+"first",i+"last")).collect(Collectors.toList());
		
	}
	@GetMapping(value ="/getmap")
	public Map<String, SampleVo> getMap(){
		Map<String, SampleVo> map = new HashMap<String, SampleVo>();
		map.put("first", new SampleVo(1111,"로꼬-잘가","양치는 청솔학원 옥상"));
		
		return map;
	}
	@GetMapping(value="/check",params = {"height","weight"})
	public ResponseEntity<SampleVo> check(Double height,Double weight){
		SampleVo vo = new SampleVo(0,""+height,""+weight);
		ResponseEntity<SampleVo> result = null;
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
		
	}
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
			@PathVariable("pid") String pid) {
		
		return new String[] {"category: "+cat,"productId: "+pid};
		
	}
	@PostMapping("/ticket") 
	public Ticket convert(@RequestBody Ticket ticket) {
		
		log.info("convert....ticket"+ticket);
		
		return ticket;
		
	}
	
}//sampleController
