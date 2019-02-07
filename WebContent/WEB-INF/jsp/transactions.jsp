<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Past Transactions
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		  <div class="container-fluid navbarId">
		    <a href="file:///E:/Angular/spring/index.html" class="navbar-brand">Bakalis Apps</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item">
		          <a href="#" class="nav-link">Home</a>
		        </li>
		        <li class="nav-item">
		          <a href="#" class="nav-link">About</a>
		        </li>
		        <li class="nav-item">
		          <a href="#" class="nav-link">Contact</a>
		        </li>
		        <li class="nav-item">
		          <a href="file:///E:/Angular/spring/login.html" class="nav-link">Login</a>
		        </li>
		      </ul>
		    </div>
		  </div>
	</nav>


	<div class="container-fluid">
		<div class="content-wrapper">
			<h1 class="text-center pageTitle">Past Transactions</h1>
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-dark">
						<thead>
						    <tr>
						      <th>#</th>
						      <th>Product Id</th>
						      <th>Product Name</th>
						      <th>Category</th>
						      <th>Quantity</th>
						      <th>Storage Code</th>
						    </tr>
							<c:forEach var="transaction" items="${transactions}" varStatus="status">
								<tr>
									<td><c:out value="${status.index+1}"/></td>
									<td><c:out value="${transaction.getProduct().getId()}"/></td>
									<td><c:out value="${transaction.getProduct().getProductName()}"/></td>
									<td><c:out value="${transaction.getClient().getClientName()}"/></td>
									<td><c:out value="${transaction.getQuantityChange()}"/></td>
									<td><c:out value="${transaction.getCreated()}"/></td>
								</tr>
							</c:forEach>
  						</thead>
					</table>
				</div>	
			</div>

		</div>

	</div>	

	

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/popper.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

</body>
</html>