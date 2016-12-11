/*globals
	angular, console
*/

var app = angular.module('orderApp', []);

app.controller('orderController', ['$scope', 'menuFactory', function orderController($scope, menuFactory) {
	'use strict';
	$scope.stage = 1;
	$scope.restaurants = [];
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
}]);