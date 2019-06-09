console.log("reply module......");

var replyService = (function(){
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
		
	}
	return {add:add,getList:getList};
})();