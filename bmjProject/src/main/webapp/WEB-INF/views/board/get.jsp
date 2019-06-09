<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file = "../includes/header.jsp" %>
 <!-- header -->
 
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">BOARD REGISTER</h1>
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row --> 
      <div class="row">
         <div class="col-lg-12">
             <div class="panel panel-default">
                 <div class="panel-heading"></div>
                 <!-- /.panel-heading -->
                 <div class="panel-body">
	                  	<div class="form-group">
	                  		<label>bno</label> <input class = "form-control" name="bno" value="<c:out value='${board.bno }'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>title</label> <input class = "form-control" name="title" value="<c:out value='${board.title }'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>contents</label> <input class = "form-control" name="contents" value="<c:out value='${board.contents}'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>writer</label> <input class = "form-control" name="writer" value="<c:out value='${board.writer}'/>"readonly="readonly">
	                  	</div>
	                  	<button data-oper='modify' class="btn btn-default">modify button</button>
	                  	<button data-oper='list'  class="btn btn-default">list</button>
	                  	 
	                  	 <form id="operForm" action="/board/modify" method="get">
	                  	 	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
	                  	 	<input type="hidden" id="pagenum" name="pagenum" value='<c:out value="${cri.pagenum}"/>'>
	                  	 	<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
	                  	 	<input type="hidden" id="amount" name="keyword" value='<c:out value="${cri.keyword}"/>'>
	                  	 	<input type="hidden" id="amount" name="type" value='<c:out value="${cri.type}"/>'>
	                  	 </form>  	
	                  
                 </div>
                 <!-- /.panel-body -->
             </div>
             <!-- /.panel -->
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row -->    
     
     
     <script type="text/javascript" src="/resources/js/reply.js"></script>
     <script type="text/javascript">
	$(document).ready(function(){
		var operForm =$("#operForm");
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/modify").submit();
		});
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
		});
	});
	
	console.log("===============");
	console.log("JS test");
	
	var bnoValue = '<c:out value="${board.bno}"/>';
	//for replyservice add test
	replyService.add(
		{reply:"증말.. 이게 뭐야  " ,replyer:"또 안됨.. 민주 화남",bno:bnoValue},
		function (result){
			alert("Result : "+result);
		}
	);
	
	console.log("===============");
	console.log("JS test2");
	replyService.getList({bno:bnoValue,page:1},function(list){
		len = list.length || 0 ;
		for(var i =0 ;  i<len ;i++ ){
			console.log(listp[i]);
		}
	});
	
	</script>
 	 
     
<!-- footer -->
<%@include file="../includes/footer.jsp"%>