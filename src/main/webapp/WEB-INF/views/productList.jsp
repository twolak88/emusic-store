<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>eMusic Store</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<style>
body {
  padding-top: 4rem;
  padding-bottom: 3rem;
  color: #5a5a5a;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="<c:url value="/" />">eMusic Store</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav me-auto mb-2 mb-md-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="<c:url value="/" />">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/products/list" />">Products</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<div class="container-wrapper">
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
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ products }" var="product">
						<tr>
							<td><img src="#" alt="image" /></td>
							<td>${ product.name }</td>
							<td>${ product.category }</td>
							<td>${ product.condition }</td>
							<td>${ product.price }</td>			
						</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- FOOTER -->
				<footer class="container">
					<p class="float-end">
						<a href="#">Back to top</a>
					</p>
					<p>
						&copy; 2017–2021 Company, Inc. &middot; <a href="#">Privacy</a>
						&middot; <a href="#">Terms</a>
					</p>
				</footer>
			
			</div>
		</div>
	</main>


	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


</body>
</html>