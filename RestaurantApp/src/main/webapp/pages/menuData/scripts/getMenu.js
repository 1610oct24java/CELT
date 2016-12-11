/*global
	app, console
*/

app.factory('menuFactory', ['$http',
	function ($http) {
		'use strict';
		var menuFactory = {},
			url = 'viewMyMenu',
			restaurant = 'viewRestaurantList';

		menuFactory.getRestaurants = function () {
			return $http.get(restaurant);
		};
		
		menuFactory.getMenu = function () {
			return $http.get(url);
		};
		
		menuFactory.postMenu = function (menu) {
			console.log("menuFactory.postMenu" + menu);
			return $http.post(url, angular.toJson(menu));
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