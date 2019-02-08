<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Manage Clients
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<jsp:include page="navbar.jsp"/>


	<div class="container-fluid">
		<div class="content-wrapper">
			<h1 class="text-center pageTitle">Manage Clients</h1>
			<c:if test="${error!=null}">
				<div class="alert alert-danger text-center">
					<s:property value="error"/>
				</div>
			</c:if>
			<form method="post">
				<div class="form-row searchRow">
					<div class="col-lg-11">
						<s:textfield cssClass="searchBar" name="searchBar"/>
					</div>
					<div class="col-lg-1">
						<input type="submit" value="Search!" class="btn searchBtn"/>
					</div>
				</div>	
			</form>
			<div class="row">
				<a href="<s:url value="/addClient.action"/>" class="btn btnAdd">Add a new Client</a>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-dark">
						<thead>
						    <tr>
						      <th>#</th>
						      <th>Client Id</th>
						      <th>Client Name</th>
						    </tr>
							<c:forEach var="client" items="${clients}" varStatus="status">
								<tr>
									<td><c:out value="${status.index+1}"/></td>
									<td><c:out value="${client.getId()}"/></td>
									<td><c:out value="${client.getClientName()}"/></td>
									<td><a href="<s:url value="/addClient.action"><s:param name="editedId"><c:out value="${client.getId()}"/></s:param></s:url>" class="link">Edit</a></td>
									<td><a href="<s:url value="/clients.action"><s:param name="deleteId"><c:out value="${client.getId()}"/></s:param></s:url>" class="link">Delete</a></td>
								</tr>
							</c:forEach>
  						</thead>
					</table>
				</div>	
			</div>

		</div>

	</div>	

	

<script type="text/javascript" src="<s:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/resources/js/popper.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>
</html>