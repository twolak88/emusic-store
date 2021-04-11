var customerApp = angular.module("customerApp", []);

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

customerApp.config(($httpProvider) => {
	$httpProvider.defaults.headers.common[header] = token;
});

customerApp.controller("customerCtrl", ($scope, $http, $window) => {
	$scope.enableCustomer = (customerId) => {
		$http.put("/emusic-store/admin/rest/customers/enable/" + customerId)
			.then(() => $window.location.reload());
	};
	
	$scope.disableCustomer = (customerId) => {
		$http.put("/emusic-store/admin/rest/customers/disable/" + customerId)
			.then(() => $window.location.reload());
	};
	
	$scope.deleteCustomer = (customerId, username) => {
		var result = confirm("Are you sure to delete user: " + username);
		if (result) {
			$http.delete("/emusic-store/admin/rest/customers/delete/" + customerId)
				.then(() => $window.location.reload());
		}
	};
});