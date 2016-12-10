var app = angular.module('myApp',[]);
app.controller('orderCtrl', ['$scope', function($scope){
	$scope.showTheBox = true;
	$scope.processForm = function() {
		$scope.showTheBox = !$scope.showTheBox;
	};
	$scope.orderitem = {
		quantity : 0,
		price : 0,
		itemname : ""
	};
	$scope.order = {
		orderitemlist = [],
		total = 0
	};
	$scope.addtoorder = function(orderItem) {
		$scope.order.orderlist.push(orderItem);
		$scope.order.total += $scope.orderItem.price;
	};
}]);