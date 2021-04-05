<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Customer</h1>

			<p class="lead">Shipping Details</p>
		</div>
		<form:form modelAttribute="order" class="form-horizontal">
			
			<h3>Shipping Address</h3>
			<div class="form-group mb-3">
				<label for="shippingStreet" class="form-label fw-bold">Street Name</label>
				<form:errors path="cart.customer.shippingAddress.streetName" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="shippingApartmentNumber" class="form-label fw-bold">Apartment Number</label>
				<form:errors path="cart.customer.shippingAddress.apartmentNumber" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="shippingCity" class="form-label fw-bold">City</label>
				<form:errors path="cart.customer.shippingAddress.city" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="shippingState" class="form-label fw-bold">State</label>
				<form:errors path="cart.customer.shippingAddress.state" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="shippingCountry" class="form-label fw-bold">Country</label>
				<form:errors path="cart.customer.shippingAddress.country" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-control" />
			</div>
			<div class="form-group mb-3">
				<label for="shippingZipCode" class="form-label fw-bold">Zip Code</label>
				<form:errors path="cart.customer.shippingAddress.zipCode" cssStyle="color: red" />
				<form:input path="cart.customer.shippingAddress.zipCode" id="shippingZipCode" class="form-control" />
			</div>
			
			<input type="hidden" name="_flowExecutionKey" />
			
			<button class="btn btn-default" name="_eventId_backToCollectCustomrInfo">Back</button>
			<input type="submit" value="Next" class="btn btn-success" name="_eventId_shippingDetailCollected"/>
			<button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>