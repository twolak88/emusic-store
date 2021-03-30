var cartApp = angular.module("cartApp", []);

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

cartApp.config(($httpProvider) => {
	$httpProvider.defaults.headers.common[header] = token;
});

cartApp.controller("cartCtrl", ($scope, $http) => {
	
	$scope.refreshCart = () => {
		$http.get("/emusic-store/rest/cart/" +  $scope.cartId)
			.then(data => {
				$scope.cart = data.data;
			});
	};
	
	$scope.clearCart = () => {
		$http.put("/emusic-store/rest/cart/items/remove")
			.then(() => $scope.refreshCart());
	};
	
	$scope.initCartId = (cartId) => {
		$scope.cartId = cartId;
		$scope.refreshCart();
	};
	
	$scope.addToCart = (productId) => {
		$http.put("/emusic-store/rest/cart/add/" + productId)
			.then(data => {
				if ($scope.cartId === null || $scope.cartId === undefined) {
					$scope.initCartId(data.data.id);
				}
				$scope.refreshCart()
					alert("Product successfully added to cart id " + data.data.id);
				});
	};
	
	$scope.removeFromCart = (productId) => {
		$http.put("/emusic-store/rest/cart/remove/" + productId)
			.then(data => $scope.refreshCart());
	};
});