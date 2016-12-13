/*global
	app, console
*/

app.factory('menuFactory', ['$http',
	function ($http) {
		'use strict';
		var menuFactory = {},
			url = 'viewMyMenu',
			data;
		
		menuFactory.getRestaurant = function () {
			console.log("Getting Restaurant");
			return $http.get(url+"?action=restaurant");
		};
		
		menuFactory.getStars = function () {
			console.log("Getting Raiting");
			return $http.get(url+"?action=stars")
		}
		
		menuFactory.getMenu = function () {
			console.log("Getting Menu");
			return $http.get(url+"?action=menu");
			url = 'viewMyMenu';
		}
		
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