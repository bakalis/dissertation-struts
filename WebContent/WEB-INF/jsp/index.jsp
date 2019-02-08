<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>
		Warehouse Contents
	</title>
	
	<link href="<s:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/css/styles4.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<jsp:include page="navbar.jsp"/>


	<div class="container-fluid">
		<div class="content-wrapper">
			<h1 class="text-center pageTitle">Warehouse Current Contents</h1> 
			<c:if test="${error!=null}">
				<div class="alert alert-danger text-center">
					<s:property value="error"/>
				</div>
			</c:if>
			<form method="post">
					<div class="form-row searchRow">
						<div class="col-lg-10">
							<s:textfield cssClass="searchBar" name="searchBar"/>
						</div>
						<div class="col-lg-1">
						<s:select name="searchFilter" list="#{'id':'By Product Id', 'name':'By Product Name','category':'By Category','code':'By Storage Code'}"
                          cssClass="searchFilter"/>		
						</div>
						<div class="col-lg-1">
							<input type="submit" class="btn searchBtn" value="Search!"/>
						</div>
					</div>	
			</form>
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
							<c:forEach var="product" items="${contents}" varStatus="status">
								<tr>
									<td><c:out value="${status.index+1}"/></td>
									<td><c:out value="${product.getId()}"/></td>
									<td><c:out value="${product.getProductName()}"/></td>
									<td><c:out value="${product.getCategory().getCategoryName()}"/></td>
									<td><c:out value="${product.getQuantity()}"/></td>
									<td><c:out value="${product.getStorageCode()}"/></td>
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