/*global
	angular, console
*/

var app = angular.module('restaurantApp', []);

app.controller('restaurantController',
	['$scope', 'menuFactory', function restaurantController($scope, menuFactory) {
        'use strict';
    	$scope.newItems = [];
		$scope.hideDeleted = "true";
		$scope.hideComments = true;
        menuFactory.getRestaurant().success(function (data) {
        	console.log(data);
        	$scope.restaurant = data;
        	menuFactory.getStars().success(function (data){
        		$scope.restaurant.raiting = data;
    			if(data)
    				$scope.hideComments = "";
        	});
        });
        $scope.addMenuItem = function () {
    		var newItem = {
                    name: $scope.newName,
                    description: $scope.newDescription,
                    price: $scope.newPrice,
                    soldOut: ""
    			};
    		$scope.restaurant.menu.push(newItem);
    		$scope.newItems.push(newItem);
            $scope.newName = "";
            $scope.newDescription = "";
            $scope.newPrice = 0;
            $scope.inputStyle = {background: 'white'};
        };
	
		$scope.remove = function () {
			var oldMenu = $scope.restaurant.menu;
			
			$scope.restaurant.menu = [];
			$scope.deletedMenu = [];
			$scope.hideDeleted = "true";
			angular.forEach(oldMenu, function (item) {
				if (!(item.deleted)) {
					$scope.restaurant.menu.push(item);
				} else {
					$scope.hideDeleted = "";
					$scope.deletedMenu.push(item);
				}
			});
		};
	
		$scope.restore = function () {
			var oldDeletions = $scope.deletedMenu;
			
			$scope.deletedMenu = [];
			$scope.hideDeleted = "true";
			angular.forEach(oldDeletions, function (item) {
				if (!(item.restored)) {
					$scope.hideDeleted = "";
					$scope.deletedMenu.push(item);
				} else {
					$scope.restaurant.menu.push(item);
				}
			});
		};
		
		$scope.commit = function () {
			var toDelete = $scope.deletedMenu,
				toAdd = $scope.newItems,
				trueAdd = [],
				i,
				addCheck = function (item) {
					if (item !== toAdd[i]) {
						trueAdd.push(item);
					}
				};

				for(i = 0; i < toDelete.length; i += 1){
					delete toDelete[i].deleted;
					delete toDelete[i].restored;
				}
				for(i = 0; i < toAdd.length; i += 1){
					delete toAdd[i].deleted;
					delete toAdd[i].restored;
				}
			
				console.log(toAdd);
				console.log(toDelete);

			for (i = 0; i < toAdd.length; i += 1) {
				delete toAdd[i].deleted;
				console.log(toAdd[i]);
				angular.forEach(toDelete, addCheck);
			}
			console.log("$scope.commit - " + toDelete + "; " + trueAdd);
			
			if(toDelete[0])
				menuFactory.deleteMenu(toDelete);
			if(trueAdd[0])
				menuFactory.postMenu(trueAdd);
		};
	}]);

//-------------------------------------------------------------------------------------------------------