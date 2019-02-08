<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Manage Categories
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<jsp:include page="navbar.jsp"/>
	


	<div class="container-fluid">
		<div class="content-wrapper">
			<c:if test="${editedCategory==null}">
				<h1 class="text-center pageTitle">Category Creation</h1>
			</c:if>
			<c:if test="${editedCategory!=null}">
				<h1 class="text-center pageTitle">Category Editing</h1>
			</c:if>
			<c:if test="${error!=null}">
				<div class="alert alert-danger text-center">
					<s:property value="error"/>
				</div>
			</c:if>
				<div class="form-wrapper"> 
					<form class="transactionForm" method="post">
						<div class="form-group row">
							<label for="categoryId" class="col-sm-2 col-form-label">Category Id:</label>
							<div class="col-lg-10">
								<c:if test="${editedCategory!=null}">
									<s:textfield cssClass="form-control" name="editedCategory.id" readonly="true"/>
								</c:if>
								<c:if test="${editedCategory==null}">
									<s:textfield cssClass="form-control" name="newCategoryId" placeholder="Insert Category Id here"/>
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label for="category" class="col-sm-2 col-form-label">Category:</label>
							<div class="col-lg-10">
								<c:if test="${editedCategory!=null}">
									<s:textfield cssClass="form-control" name="editedCategory.categoryName"/>
								</c:if>
								<c:if test="${editedCategory==null}">
									<s:textfield cssClass="form-control" name="newCategoryName" placeholder="Insert Category Name here"/>
								</c:if>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-10 btnRow">
								<c:if test="${editedCategory!=null}">
									<input type="submit" class="btn btn-inverse" value="Edit Category"/>
								</c:if>
								<c:if test="${editedCategory==null}">
									<input type="submit" class="btn btn-inverse" value="Create Category"/>
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