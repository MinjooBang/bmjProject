package org.mjmj.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pagenum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pagenum,int amount) {
		this.pagenum = pagenum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
									.queryParam("pagenum",this.pagenum)
									.queryParam("amount", this.amount)
									.queryParam("type", this.type)
									.queryParam("keyword", this.keyword);
		return builder.toUriString();
									
	}
	

}
