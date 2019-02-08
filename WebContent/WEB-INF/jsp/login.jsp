<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Log In Page
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

	<jsp:include page="navbar.jsp"/>


	<div class="container-fluid">
		<div class="content-wrapper">
			<h1 class="text-center pageTitle">Log In Page</h1>
			<div class="form-wrapper"> 
				<form class="transactionForm" method="post">
					  <div class="form-group row">
					    <label for="username" class="col-sm-2 col-form-label">Username:</label>
					    <div class="col-lg-10">
					      <input type="text" name="username" class="form-control" placeholder="Insert Username here"/>
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="password" class="col-sm-2 col-form-label">Password:</label>
					    <div class="col-lg-10">
					      <input type="password" name="password" class="form-control" placeholder="Insert Password here"/>
					    </div>
					  </div>
					  <div class="form-group row">
					    <div class="col-lg-10 btnRow">
					     	<input type="submit" class="btn btn-inverse" value="Log in"/>
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