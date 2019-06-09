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
                   <form  role="form"  action="/board/modify_update" method="post">
	                  	<div class="form-group">
	                  		<label>title</label> <input class = "form-control" name="bno" value="<c:out value='${board.bno }'/>" readonly="readonly">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>title</label> <input class = "form-control" name="title" value="<c:out value='${board.title }'/>" >
	                  	</div>
	                  	<div class="form-group">
	                  		<label>contents</label> <input class = "form-control" name="contents" value="<c:out value='${board.contents}'/>" >
	                  	</div>
	                  	<div class="form-group">
	                  		<label>writer</label> <input class = "form-control" name="writer" value="<c:out value='${board.writer}'/>" >
	                  	</div>
	                 
	                  	<input type="hidden" name="pagenum" id="pagenum" value='<c:out value="${cri.pagenum }"/>'/>
	                  	<input type="hidden" name="amount" id="amount" value='<c:out value="${cri.amount }"/>'/>
	                  	<input type="hidden" name="type" id="type"value='<c:out value="${cri.type }"/>'/>
	                  	<input type="hidden" name="keyword" id="keyword"value='<c:out value="${cri.keyword }"/>'/>
	                  	
	                  	<button type="submit" data-oper='modify'  class="btn btn-default">modify</button>
	                  	<button type="submit" data-oper='remove'  class="btn btn-danger">remove</button>
	                  	<button type="submit" data-oper='list'  class="btn btn-info">list</button>
	                  </form>	     	
	                  
                 </div>
                 <!-- /.panel-body -->
             </div>
             <!-- /.panel -->
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row --> 
	<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form");
		$("button").on("click",function(e){
			e.preventDefault();
			var operation = $(this).data("oper");
			if (operation === 'remove'){
				formObj.attr("action","/board/remove");
			}else if (operation === 'list'){
				formObj.attr("action","/board/list").attr("method","get");
				var pageNum = $("#pagenum").clone();
				var amount = $("#amount").clone();
				var type = $("#type").clone();
				var keyword = $("#keyword").clone();
				formObj.empty();
				formObj.append(pageNum);
				formObj.append(amount);
				formObj.append(type);
				formObj.append(keyword);
				
			}
			formObj.submit();
		});
	});
	</script>
 	
     
<!-- footer -->
<%@include file="../includes/footer.jsp"%>