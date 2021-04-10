<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/jsp/template/header.jsp"%>

<script>
	$(document).ready(() => {
		var searchCondition = '${searchCondition}';
		
		$('.table').DataTable({
			"lengthMenu": [[1,2,3,5,10,-1], [1,2,3,5,10,"All Products"]],
			"pageLength": 3,
			"oSearch": {"sSearch": searchCondition}
		});
	});
</script>

<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>

			<p class="lead">Checkout all the awesome products available now!</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="table-dark">
					<th>Photo thumb</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ products }" var="product">
					<tr>
						<td><img src="<c:url value="${ product.imageUrl }" />" alt="image" style="height: 150px;" /></td>
						<td>${ product.name }</td>
						<td>${ product.category }</td>
						<td>${ product.condition }</td>
						<td>${ product.price }</td>
						<td>
							<a href="<spring:url value="/products/${ product.id }" />">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16">
	  								<path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
								</svg>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="/WEB-INF/views/jsp/template/footer.jsp"%>