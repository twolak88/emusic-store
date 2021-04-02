<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Customer registration</h1>

			<p class="lead">Fill in your information</p>
			<form:form method="post" 
				action="${pageContext.request.contextPath}/register?${_csrf.parameterName}=${_csrf.token}" 
				modelAttribute="customer">
				
				<h3>Basic info</h3>
				<div class="form-group mb-3">
					<label for="name" class="form-label fw-bold">Name</label>
					<form:errors path="name" cssStyle="color: red" />
					<form:input path="name" id="name" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="email" class="form-label fw-bold">Email</label>
					<form:errors path="email" cssStyle="color: red" />
					<form:input path="email" id="email" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="phone" class="form-label fw-bold">Phone</label>
					<form:errors path="phone" cssStyle="color: red" />
					<form:input path="phone" id="phone" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="username" class="form-label fw-bold">Username</label>
					<form:errors path="username" cssStyle="color: red" />
					<form:input path="username" id="username" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="password" class="form-label fw-bold">Password</label>
					<form:errors path="password" cssStyle="color: red" />
					<form:password path="password" id="password" class="form-control" />
				</div>
				<form:hidden path="enabled" value="${customer.enabled}" />
				
				<h3>Billing Address</h3>
				<div class="form-group mb-3">
					<label for="billingStreet" class="form-label fw-bold">Street Name</label>
					<form:errors path="billingAddress.streetName" cssStyle="color: red" />
					<form:input path="billingAddress.streetName" id="billingStreet" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="billingApartmentNumber" class="form-label fw-bold">Apartment Number</label>
					<form:errors path="billingAddress.apartmentNumber" cssStyle="color: red" />
					<form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="billingCity" class="form-label fw-bold">City</label>
					<form:errors path="billingAddress.city" cssStyle="color: red" />
					<form:input path="billingAddress.city" id="billingCity" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="billingState" class="form-label fw-bold">State</label>
					<form:errors path="billingAddress.state" cssStyle="color: red" />
					<form:input path="billingAddress.state" id="billingState" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="billingCountry" class="form-label fw-bold">Country</label>
					<form:errors path="billingAddress.country" cssStyle="color: red" />
					<form:input path="billingAddress.country" id="billingCountry" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="billingZipCode" class="form-label fw-bold">Zip Code</label>
					<form:errors path="billingAddress.zipCode" cssStyle="color: red" />
					<form:input path="billingAddress.zipCode" id="billingZipCode" class="form-control" />
				</div>
				
				<h3>Shipping Address</h3>
				<div class="form-group mb-3">
					<label for="shippingStreet" class="form-label fw-bold">Street Name</label>
					<form:errors path="shippingAddress.streetName" cssStyle="color: red" />
					<form:input path="shippingAddress.streetName" id="shippingStreet" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="shippingApartmentNumber" class="form-label fw-bold">Apartment Number</label>
					<form:errors path="shippingAddress.apartmentNumber" cssStyle="color: red" />
					<form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="shippingCity" class="form-label fw-bold">City</label>
					<form:errors path="shippingAddress.city" cssStyle="color: red" />
					<form:input path="shippingAddress.city" id="shippingCity" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="shippingState" class="form-label fw-bold">State</label>
					<form:errors path="shippingAddress.state" cssStyle="color: red" />
					<form:input path="shippingAddress.state" id="shippingState" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="shippingCountry" class="form-label fw-bold">Country</label>
					<form:errors path="shippingAddress.country" cssStyle="color: red" />
					<form:input path="shippingAddress.country" id="shippingCountry" class="form-control" />
				</div>
				<div class="form-group mb-3">
					<label for="shippingZipCode" class="form-label fw-bold">Zip Code</label>
					<form:errors path="shippingAddress.zipCode" cssStyle="color: red" />
					<form:input path="shippingAddress.zipCode" id="shippingZipCode" class="form-control" />
				</div>
				
				<input type="submit" value="Submit" class="btn btn-success" />
				<a href="<spring:url value="/" />" class="btn btn-danger">Cancel</a>
			</form:form>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>