'use strict';

(()=>{
	angular.module('awesome-app.di')
		.constant('diRoutes', {	
			createDeliveryInformation : {
				url: '/createDeliveryInformation',
				templateUrl: '/RestaurantApp/pages/resources/deliveryInformation/deliveryInformation.template.html',
				controller: 'diController',
				controllerAs: '$deliveryInformationCtrl'
			},
			
			createDeliveryInformationSuccess : {
				url: '/createDeliveryInformationSuccess',
				templateUrl: '/RestaurantApp/pages/resources/deliveryInformation/deliveryInformation.template.html',
				controller: 'diController',
				controllerAs: '$deliveryInformationCtrl'
			},
			
			createDeliveryInformationFailure : {
				url: '/createDeliveryInformationFailure',
				templateUrl: '/RestaurantApp/pages/resources/deliveryInformation/deliveryInformation.template.html',
				controller: 'diController',
				controllerAs: '$deliveryInformationCtrl'
			}
			
		});
	
})();