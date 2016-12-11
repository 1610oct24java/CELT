'use strict';

(() => {
	angular.module('awesome-app.login')
	.constant('loginRoutes', {
		
		login: {
			url: '/login',
			templateUrl: '/RestaurantApp/pages/resources/login/login.template.html',
			controller: 'loginController',
			controllerAs: '$loginCtrl'
			
		},
		
		managerRoute : {
			url : '/Welcome',
			templateUrl: '/RestaurantApp/pages/resources/manager/manager.template.html',
		},
		customerRoute: {
			url: '/Welcome',
			templateUrl: '/RestaurantApp/pages/resources/customer/customer.template.html',	
		}
		
	})
})();