<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Customer</h1>

			<p class="lead">Customer Details</p>
		</div>
		<form:form modelAttribute="order" class="form-horizontal">
			
			<h3>Basic info</h3>
			<div class="form-group mb-3">
				<label for="name" class="form-label fw-bold">Name</label>
				<form:errors path="cart.customer.name" cssStyle="color: red" />
				<form:input path="cart.customer.name" id="name" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="email" class="form-label fw-bold">Email</label>
				<form:errors path="cart.customer.email" cssStyle="color: red" />
				<form:input path="cart.customer.email" id="email" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="phone" class="form-label fw-bold">Phone</label>
				<form:errors path="cart.customer.phone" cssStyle="color: red" />
				<form:input path="cart.customer.phone" id="phone" class="form-control" />
			</div>
			<form:hidden path="cart.customer.enabled" value="${customer.enabled}" />
			<form:hidden path="cart.customer.username" value="${customer.enabled}" />
			<form:hidden path="cart.customer.password" value="${customer.enabled}" />
			
			<h3>Billing Address</h3>
			<div class="form-group mb-3">
				<label for="billingStreet" class="form-label fw-bold">Street Name</label>
				<form:errors path="cart.customer.billingAddress.streetName" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.streetName" id="billingStreet" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="billingApartmentNumber" class="form-label fw-bold">Apartment Number</label>
				<form:errors path="cart.customer.billingAddress.apartmentNumber" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="billingCity" class="form-label fw-bold">City</label>
				<form:errors path="cart.customer.billingAddress.city" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="billingState" class="form-label fw-bold">State</label>
				<form:errors path="cart.customer.billingAddress.state" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.state" id="billingState" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="billingCountry" class="form-label fw-bold">Country</label>
				<form:errors path="cart.customer.billingAddress.country" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="billingZipCode" class="form-label fw-bold">Zip Code</label>
				<form:errors path="cart.customer.billingAddress.zipCode" cssStyle="color: red" />
				<form:input path="cart.customer.billingAddress.zipCode" id="billingZipCode" class="form-control" />
			</div>
			
			<input type="hidden" name="_flowExecutionKey" />
			
			<input type="submit" value="Next" class="btn btn-success" name="_eventId_customerInfoCollected"/>
			<button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>