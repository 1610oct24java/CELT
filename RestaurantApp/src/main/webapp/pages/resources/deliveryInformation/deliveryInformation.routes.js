'use strict';

(()=>{
	angular.module('awesome-app.deliveryInformation')
		.constant('deliveryInformationRoutes', {	
			deliveryAddress : {
				url : '/createDeliveryInformation',
				templateUrl : '/RestaurantApp/resources/deliveryInformation.template.html',
				controller : 'deliveryInformationController',
				controllerAs : '$deliveryInformationCtrl'
			}
		});
	
})();