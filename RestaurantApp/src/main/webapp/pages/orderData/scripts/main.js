/*globals
	angular, console
*/

var app = angular.module('orderApp', []);

app.controller('orderController', ['$scope', 'menuFactory', function orderController($scope, menuFactory) {
	'use strict';
	$scope.menu = true;
	$scope.restaurants = [];
	$scope.reviews = [];
	$scope.order = [];
	$scope.contactInfo = {};
	$scope.stage = 0;
	$scope.street = "1234 No Way";
	$scope.city = "Nowhere";
	$scope.state = "Canada";
	$scope.zip = 12345;
	$scope.phone = "(123) 456-7890";
	$scope.email = "FLast@Email.net";		
	
	$scope.checkStage = function (s) {
		return $scope.stage === s;
	}
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
	$scope.back = function () {
		if($scope.stage < 3){
			$scope.order = [];
		}
		$scope.stage -= 1;
	};
	$scope.viewReviews = function (restaurant) {
		$scope.reviews = restaurant.reviews;
		$scope.showReviews = true;
	};
	$scope.enterCI = function () {
		$scope.stage = 3;
	};
	$scope.finalize = function () {
		$scope.stage = 4;
	};
	$scope.submit = function () {
		$scope.stage = 5;
		var invoice = {
				"status": 0,
				"total": $scope.getTotal(),
				"contact": {
					"street": $scope.street,
					"city": $scope.city ,
					"state": $scope.state,
					"zip": $scope.zip,
					"phone": $scope.phone,
					"email": $scope.email					
				},
				items: []
		};
		angular.forEach($scope.order, function (food) {
			var quantity = food.quantity;
			delete food.quantity;
			var item = {
					"item":food,
					"quantity": quantity,
			};
			invoice.items.push(item);
		});
		console.log(invoice);
		menuFactory.postOrder(invoice);
	}
}]);