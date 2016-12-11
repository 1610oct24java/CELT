var app = angular.module("myApp",[])
app.controller('registerRestaurantCtrl',['$scope','ResFactory', function registerRestaurantCtrl($scope,ResFactory){
	$scope.saveData = function(){
		var info = {
				street: $scope.street,
				city:$scope.city,
				state:$scope.state,
				zip:$scope.zip,
				phone: $scope.phone,
				email:$scope.email
					
		}
		 var rest = {
				name:$scope.resname
					
		}
		 var man = {
				username: $scope.uname,
				password: $scope.pword
		}
		console.log("hello.inside saveData")
		ResFactory.postData(info,rest,man);
	};
}]);
app.factory('ResFactory', ['$http',
    function($http){
	var ResFactory = {},
	url = 'restaurant';
	
	ResFactory.postData = function(info,res,man)
	{
		console.log("hello.inside postData")
		var Data = {
				"info":angular.toJson(info), 
				"restaurant":angular.toJson(res), 
				"manager":angular.toJson(man)	
				
		}
		return $http.post(url, Data);
	}
	return ResFactory;
}]);