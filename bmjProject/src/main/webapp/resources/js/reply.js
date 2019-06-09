console.log("reply module......");

var replyService = (
		
function(){
	function add(reply,callback,error){
		console.log("add reply....");
		$.ajax({
			type: 'post'
			,url: '/replies/new'
			,data:JSON.stringify(reply),
			contentType:"application/json;charset=UTF-8",
			sucess:function(result,status,xhr){
				if (callback){
					callback(result);
				}
			},
			error:function(){
				if(error){
					error(er);
				}
			}
			
		});
	}//add
	
	function getList(param,callback,error){
		var bno =param.bno;
		var page = param.page ||1;
		
		console.log("/replies/page/"+bno+"/"+page+".json");
		//요기서 에러나면.. 나보고 어쩌라는 거지?
		$.getJSON("/replies/page/"+bno+"/"+page+".json",
			function(data){
				if (callback){
					callback(data);
				}
			}).fail(function(xhr,status,err){
				if(error){
					error();
				}
			});
		
	}//getList
	
	function remove(rno,callback,error){
		console.log(rno);
		$.ajax({
			type:'delete',
			url:'/replies/'+rno,
			success:function(deleteResult,status,xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}//remove
	
	function update(reply,callback,error){
		console.log("RNO :"+reply.rno);
		$.ajax({
			type:'put',
			url:'/replies/'+reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=UTF-8",
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}//update
	
	return {add:add,
			getList:getList,
			remove:remove,
			update:update};
	
})();