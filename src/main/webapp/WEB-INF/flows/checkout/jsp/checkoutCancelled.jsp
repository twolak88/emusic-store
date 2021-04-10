<%@include file="/WEB-INF/views/jsp/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1 class="alert alert-danger">Checkout cancelled</h1>

			<p class="lead">Your checkout process is cancelled. You may continue shopping.</p>
		</div>
		<section class="container">
			<p>
				<a href="<spring:url value="/products/all" />" class="btn btn-success">Products</a>
			</p>
		</section>
	</div>
</div>
<%@include file="/WEB-INF/views/jsp/template/footer.jsp"%>