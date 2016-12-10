var app = angular.module("myApp",[])
app.controller('registerRestaurantCtrl', function registerRestaurantCtrl($scope){
	$scope.saveData = function(){
		var info = {
				street: $scope.street,
				city:$scope.city,
				State:$scope.state,
				Zipcode:$scope.zipcode,
				Phone: $scope.cel,
				Email:$scope.email
					
		}
		var restaurant = {
				name:$scope.resname
					
		}
		var manager = {
				username: $scope.uname,
				password: $scope.pword
		}
		console.log("hello.")
		ResFactory.postData(info,restaurant,manager);
	};
});

app.factory('ResFactory', ['$http',
    function($http){
	var ResFactory = {},
	url = 'restaurant';
	
	ResFactory.postData = function(info,res,man)
	{
		var Data = {
				"info":angular.toJson(info), 
				"restaurant":angular.toJson(res), 
				"manager":angular.toJson(man)	
				
		}
		return $http.post(url, Data);
	}
	return ResFactory;
}]);