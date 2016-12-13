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
			return $http.post(url, angular.toJson(menu));
		};
		
		menuFactory.postOrder = function (order) {
			console.log("menuFactory.postOrder");
			console.log(order);
			return $http.post(order, angular.toJson(order));
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