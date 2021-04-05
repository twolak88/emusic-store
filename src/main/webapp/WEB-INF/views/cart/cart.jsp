<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-wrapper" style="padding-top: 5rem;">
	<div class="container">
		<div class="page-header">
			<h1>Cart</h1>

			<p class="lead">All the selected products in your shopping cart</p>
		</div>
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				<div>
					<a href="#" class="btn btn-danger pull-left" ng-click="clearCart()">
					<span>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
						  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
						</svg>
					</span>
					Clear Cart</a>
					<a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right">
					<span>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
						  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
						</svg>
					</span>
					Check out</a>
				</div>
				
				<table class="table table-striped table-hover">
					<thead>
						<tr class="table-dark">
							<th>Product</th>
							<th>Unit price</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in cart.cartItems">
							<td>{{item.product.name}}</td>
							<td>{{item.product.price}}</td>
							<td>{{item.quantity}}</td>
							<td>{{item.totalPrice}}</td>
							<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)">
								<span>
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
								  		<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
									</svg>
								</span>remove</a></td>
						</tr>
						<tr>
							<th></th>
							<th></th>
							<th>Grand Total</th>
							<th>{{cart.grandTotal}}</th>
							<th></th>
						</tr>
					</tbody>
				</table>
				<a href="<spring:url value="/products/all" />" class="btn btn-default">Continue Shopping</a>
			</div>
		</section>
	</div>
</div>
<script src="<c:url value="/resources/js/controller.js" />" ></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>