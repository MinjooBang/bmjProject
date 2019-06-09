package org.mjmj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mjmj.domain.Criteria;
import org.mjmj.domain.ReplyVo;

public interface replyMapper {
	
	public int insert(ReplyVo vo);
	public ReplyVo read(long bno);
	public int delete(long rno);
	public int update(ReplyVo vo);
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria cri,@Param("bno") Long bno);

}
