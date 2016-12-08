'use strict';

(()=>{
	angular.module('awesome-app.deliveryInformation')
		.constant('deliveryInformaitionRoutes', {
			
			deliveryAddress : {
				url : '/createDeliveryInformation',
				templateUrl : '/RestaurantApp/pages/deliveryInformation.template.html',
				controller : 'deliveryInformationController',
				controllerAs : '$deliveryInformationCtrl'
			}
		});
	
})();