/*global
	app, console
*/

app.factory('menuFactory', ['$http',
	function ($http) {
		'use strict';
		var menuFactory = {},
			url = 'viewMyMenu',
			order = 'orderProcessing';

		menuFactory.getRestaurants = function () {
			return $http.get(order);
		};
		
		menuFactory.getMenu = function () {
			return $http.get(url);
		};
		
		menuFactory.postMenu = function (menu) {
			console.log("menuFactory.postMenu" + menu);
			menu = angular.toJson(menu);
			return $http.post(url, menu);
		};
		
		menuFactory.postOrder = function (invoice) {
			console.log("menuFactory.postOrder");
			invoice = angular.toJson(invoice);
			console.log(typeof invoice)
			return $http.post(order, invoice);
		};
		
		menuFactory.deleteMenu = function (menu) {
			return $http({
				method: 'DELETE',
				url: url,
				data: angular.toJson(menu)
			});
		};
		
		return menuFactory;
	}]);