<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Detail information of the product</p>
		</div>
		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img src="<c:url value="${ product.imageUrl }" />" alt="image" style="max-width: 100%; max-height: 300px;" />
				</div>
				<div class="col-md-5">
					 <h3><strong>${ product.name }</strong></h3>
					 <p>${ product.description }</p>
					 <p>
					 	<strong>Manufacturer: </strong>${ product.manufacturer }
					 </p>
					 <p>
					 	<strong>Category: </strong>${ product.category }
					 </p>
					 <p>
					 	<strong>Condition: </strong>${ product.condition }
					 </p>
					 <p>
					 	<strong>In Stock: </strong>${ product.unitInStock }
					 </p>
					 <p>
					 	<strong>Status: </strong>${ product.status }
					 </p>
					 <h4>${ product.price } PLN</h4>
					 
					 <c:set var="role" scope="page" value="${param.role}" />
					 <c:set var="url" scope="page" value="/products" />
					 <c:if test="${role='admin'}">
					 	<c:set var="url" scope="page" value="/admin/productInventory" />
					 </c:if>
					 
					 <p ng-controller="cartCtrl">
					 	<a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
					 	<a href="#" class="btn btn-warning" ng-click="addToCart('${product.id}')">
						 	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
	  							<path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
							</svg>
						 	Add to Cart</a>
						 <a href="<spring:url value="/cart" />" class="btn btn-primary">
							 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
								<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
							 </svg>
						 View Cart</a>
					 </p>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="<c:url value="/resources/js/controller.js" />" ></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>