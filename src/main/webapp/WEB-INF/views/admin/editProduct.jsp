<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Edit Product</h1>

			<p class="lead">Fill below information to update Product: ${product.name}</p>
		</div>
		<form:form method="post" 
				action="${pageContext.request.contextPath}/admin/productInventory/edit" 
				modelAttribute="product"
				enctype="multipart/form-data">
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<form:hidden path="id" value="${product.id}" />
			<form:hidden path="imageUrl" value="${product.imageUrl}" />
			
			<div class="form-group mb-3">
				<label for="name" class="form-label fw-bold">Name</label>
				<form:errors path="name" cssStyle="color: red" />
				<form:input path="name" id="name" class="form-control" value="${product.name}" />
			</div>
			
			<div class="form-group mb-3">
				<label for="category" class="form-label fw-bold col-sm-3">Category</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="category" id="category" value="instrument" />
					Instrument
				</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="category" id="category" value="record" />
					Record
				</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="category" id="category" value="accessory" />
					Accessory
				</label>
			</div>
			
			<div class="form-group mb-3">
				<label for="description" class="form-label fw-bold">Description</label>
				<form:textarea rows="3" path="description" id="description" class="form-control" value="${product.description}" />
			</div>
			
			<div class="form-group mb-3">
				<label for="price" class="form-label fw-bold">Price</label>
				<form:errors path="price" cssStyle="color: red" />
				<form:input path="price" id="price" type="number" class="form-control" value="${product.price}" />
			</div>
			
			<div class="form-group mb-3">
				<label for="condition" class="form-label fw-bold col-sm-3">Condition</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="condition" id="condition" value="new" />
					New
				</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="condition" id="condition" value="used" />
					Used
				</label>
			</div>
			
			<div class="form-group mb-3">
				<label for="status" class="form-label fw-bold col-sm-3">Status</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="status" id="status" value="active" />
					Active
				</label>
				<label class="checkbox-inline col-sm-2">
					<form:radiobutton path="status" id="status" value="inactive" />
					Inactive
				</label>
			</div>
			
			<div class="form-group mb-3">
				<label for="unitInStock" class="form-label fw-bold">Unit In Stock</label>
				<form:errors path="unitInStock" cssStyle="color: red" />
				<form:input path="unitInStock" id="unitInStock" type="number" class="form-control" value="${product.unitInStock}" />
			</div>
			
			<div class="form-group mb-3">
				<label for="manufacturer" class="form-label fw-bold">Manufacturer</label>
				<form:input path="manufacturer" id="manufacturer" class="form-control" value="${product.manufacturer}" />
			</div>
			
			<div class="form-group mb-5">
				<label for="image" class="control-label fw-bold">Upload Image</label>
				<form:input path="image" id="image" type="file" class="form-control" />
			</div>
			
			<input type="submit" value="Submit" class="btn btn-success" />
			<a href="<spring:url value="/admin/productInventory" />" class="btn btn-danger">Cancel</a>
		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>