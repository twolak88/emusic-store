<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Administration</h1>

			<p class="lead">Administrator page!</p>
		</div>

		<h3>
			<a href="<spring:url value="/admin/productInventory" />">Product Inventory</a>
		</h3>
		<p>Here you can view, check and modify the product inventory</p>
		
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>