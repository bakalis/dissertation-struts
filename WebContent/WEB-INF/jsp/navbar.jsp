<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			  <div class="container-fluid navbarId">
			  	<a href="<s:url value="/index.action"/>" class="navbar-brand">Bakalis Apps</a>
			    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarResponsive">
			      <ul class="navbar-nav ml-auto">
			       <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Information
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				          <a href="<s:url value="/index.action"/>" class="dropdown-item">Warehouse Contents</a>
				          <a href="<s:url value="/transactions.action"/>" class="dropdown-item">Transactions</a>
				        </div>
			      </li>
			      <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Management
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				          <a href="<s:url value="/entry.action"/>" class="dropdown-item">Add Products</a>
				          <a href="<s:url value="/retrieval.action"/>" class="dropdown-item">Retrieve Products</a>
				          <a href="<s:url value="/categories.action"/>" class="dropdown-item">Manage Categories</a>
				          <a href="<s:url value="/clients.action"/>" class="dropdown-item">Manage Clients</a>
				        </div>
			      </li>
			      <c:if test="${auth.getName()=='anonymousUser'}">
				      <li class="nav-item">
				      		<a href="<s:url value="/login.action"/>" class="nav-link">Login</a>
				      </li>
			      </c:if>
			      <c:if test="${auth.getName()!='anonymousUser'}">
				      <li class="nav-item">
				      		<a href="<s:url value="/logout"/>" class="nav-link">Logout</a>
				      </li>
			      </c:if>
			      </ul>
			    </div>
			  </div>
</nav>