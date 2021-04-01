<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Administration</h1>

			<p class="lead">Administrator page!</p>
		</div>
		
		<security:authorize access="isAuthenticated()">
		    <h2>
		    	Authenticated as <security:authentication property="principal.username" />
<%-- 		    	| <a href="<c:url value="/logout" />">Logout</a> --%>
				<c:url var="logoutUrl" value="/logout"/>
				<form action="${logoutUrl}" method="post">
				    <input type="submit" value="Logout" class="btn btn-primary" />
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
		    </h2>
		</security:authorize>

		<h3>
			<a href="<spring:url value="/admin/products" />">Product Inventory</a>
		</h3>
		<p>Here you can view, check and modify the product inventory</p>
		
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>