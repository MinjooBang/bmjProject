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
                 <div class="panel-heading">BOARD REGISTER PAGE</div>
                 <!-- /.panel-heading -->
                 <div class="panel-body">
	                  <form  role="form" action="/board/register_input" method="post">
	                  	<div class="form-group">
	                  		<label>title</label> <input class = "form-control" name="title">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>contents</label> <input class = "form-control" name="contents">
	                  	</div>
	                  	<div class="form-group">
	                  		<label>writer</label> <input class = "form-control" name="writer">
	                  	</div>
	                  	
	                  	<button type="submit" class="btn btn-default">submit button</button>
	                  	     	
	                  
	                  </form>
                 </div>
                 <!-- /.panel-body -->
             </div>
             <!-- /.panel -->
         </div>
         <!-- /.col-lg-12 -->
     </div>
     <!-- /.row -->     
     
<!-- footer -->
<%@include file="../includes/footer.jsp"%>