var app = angular.module('myApp',[]);
app.controller('testCtrl',function testCtrl($scope){
	$scope.showTheBox = true;
	$scope.processForm = function() {
		$scope.showTheBox = !$scope.showTheBox;
	}
});