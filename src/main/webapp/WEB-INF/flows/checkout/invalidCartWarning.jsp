<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Invalid Cart</h1>
		</div>
		<section class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-success">Products</a>
			</p>
		</section>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>