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
			<c:if test="${editedClient==null}">
				<h1 class="text-center pageTitle">Client Creation</h1>
			</c:if>
			<c:if test="${editedClient!=null}">
				<h1 class="text-center pageTitle">Client Editing</h1>
			</c:if>
			<c:if test="${error!=null}">
				<div class="alert alert-danger text-center">
					<s:property value="error"/>
				</div>
			</c:if>
				<div class="form-wrapper"> 
					<form class="transactionForm" method="post">
						<div class="form-group row">
							<label for="clientId" class="col-sm-2 col-form-label">Client Id:</label>
							<div class="col-lg-10">
								<c:if test="${editedClient!=null}">
									<s:textfield cssClass="form-control" name="editedClient.id" readonly="true"/>
								</c:if>
								<c:if test="${editedClient==null}">
									<s:textfield cssClass="form-control" name="newClientId" placeholder="Insert Client Id here"/>
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label for="client" class="col-sm-2 col-form-label">Client:</label>
							<div class="col-lg-10">
								<c:if test="${editedClient!=null}">
									<s:textfield cssClass="form-control" name="editedClient.clientName"/>
								</c:if>
								<c:if test="${editedClient==null}">
									<s:textfield cssClass="form-control" name="newClientName" placeholder="Insert Client Name here"/>
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-10 btnRow">
								<c:if test="${editedClient!=null}">
									<input type="submit" class="btn btn-inverse" value="Edit Client"/>
								</c:if>
								<c:if test="${editedClient==null}">
									<input type="submit" class="btn btn-inverse" value="Create Client"/>
								</c:if>
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