<%@include file="/WEB-INF/views/jsp/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Order success</h1>

			<p class="lead">Thank you for your order.</p>
			<p>Your order will be shipped in 2 business days</p>
		</div>
		<section class="container">
			<p>
				<a href="<spring:url value="/" />" class="btn btn-success">OK</a>
			</p>
		</section>
	</div>
</div>
<%@include file="/WEB-INF/views/jsp/template/footer.jsp"%>