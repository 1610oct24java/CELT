/*globals
	angular, console
*/

var app = angular.module('orderApp', []);

app.controller('orderController', ['$scope', 'menuFactory', function orderController($scope, menuFactory) {
	'use strict';
	$scope.stage = 1;
	$scope.restaurants = [];
	$scope.order = [];
	menuFactory.getRestaurants().success(
		function (data) {
			$scope.restaurantList = data;
			$scope.stage = 1;
		}
	).error(function (data) {
		$scope.restaurantList = [
			{
				name: "Chicken Stop",
				reviews: [{
					stars: 3
				}, {
					stars: 1
				}, {
					stars: 5
				}, {
					stars: 5
				}, {stars: 5}]
			}, {
				name: "Fish Stop",
				reviews: [{
					stars: 1
				}, {
					stars: 1
				}, {
					stars: 2
				}, {
					stars: 1
				}, {stars: 1}]
			}
		];
	});
	$scope.getStars = function (reviews) {
		var sum = 0, i = 0;
		angular.forEach(reviews, function (review) {
			sum += review.stars;
			i += 1;
		});
		if (i === 0) {
			return 5;
		}
		return sum / i;
	};
	$scope.selectRestaurant = function (restaurant) {
		$scope.restaurant = restaurant;
		console.log(restaurant.menu);
		$scope.stage = 2;
	};
	$scope.addToOrder = function (menuItem) {
		console.log(menuItem);
		var index = $scope.order.indexOf(menuItem);
		
		if(index === -1){
			console.log("nope");
			menuItem.quantity = 1;
			$scope.order.push(menuItem);
		} else {
			$scope.order[index].quantity += 1;
		}
	};
	$scope.getTotal = function () {
		var total = 0;
		angular.forEach($scope.order, function (item) {
			total += item.price * item.quantity;
		});
		return total;
	};
	$scope.removeFromOrder = function (menuItem) {
		var index = $scope.order.indexOf(menuItem);
		if($scope.order[index].quantity < 2){
			$scope.order.splice(index, 1);
			return;
		}
		$scope.order[index].quantity -= 1;
	};
}]);