<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Detail information of the product</p>
		</div>
		<div class="container">
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
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>