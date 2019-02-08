<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Retrieve Products
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<jsp:include page="navbar.jsp"/>




	<div class="container-fluid">
		<div class="content-wrapper">
			<h1 class="text-center pageTitle">Product Retrieval</h1>
			<c:if test="${error!=null}">
				<div class="alert alert-danger text-center">
					<s:property value="error"/>
				</div>
			</c:if>
			<div class="form-wrapper"> 
				<form class="transactionForm" method="post">
					  <div class="form-group row">
					    <label for="productId" class="col-sm-2 col-form-label">Product Id:</label>
					    <div class="col-lg-10">
					      <s:textfield cssClass="form-control" name="productId" placeholder="Insert Product Id here"/>				    
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="productName" class="col-sm-2 col-form-label">Product Name:</label>
					    <div class="col-lg-10">
					      <s:textfield cssClass="form-control" name="productName" placeholder="Insert Product Name here"/>
					    </div>
					  </div>
					  <div class="form-group row">
						  <label for="categoryFilter" class="col-sm-2 col-form-label">Category:</label>
						  <div class="col-lg-10">
						  	<s:select name="category" list="categories" cssClass="categoryFilter"/>
						  </div>
					  </div>
					  <div class="form-group row">
						  <label for="clientFilter" class="col-sm-2 col-form-label">Client:</label>
						  <div class="col-lg-10">
						  	<s:select name="client" list="clients"  cssClass="clientFilter"/>
						  </div>
					  </div>
					  <div class="form-group row">
						  <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
						  <div class="col-lg-10">
						  	<s:textfield cssClass="form-control" name="quantity" placeholder="Enter Quantity here"/>
						  </div>
					  </div>
					  <div class="form-group row">
					    <label for="code" class="col-sm-2 col-form-label">Storage Code</label>
					    <div class="col-lg-10">
					    	<s:textfield cssClass="form-control" name="code" placeholder="Enter Storage Code here"/>
					    </div>
					  </div>

					  <div class="form-group row">
					    <div class="col-lg-10 btnRow">
					     	<input type="submit" class="btn btn-inverse" value="Enter Products"/>
					    </div>
					  </div>
				
				</form>
			</div>
		</div>
	</div>	


<script type="text/javascript" src="<s:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/resources/js/popper.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>
</html>