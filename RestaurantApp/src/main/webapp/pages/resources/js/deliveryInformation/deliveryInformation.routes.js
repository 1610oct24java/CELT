'use strict';

(()=>{
	angular.module('awesome-app.deliveryInformation')
		.constant('deliveryInformaitionRoutes', {
			
			deliveryAddress : {
				url : '/createAddress',
				templateUrl : '/RestaurantApp/pages/deliveryInformation.template.html',
				controller : 'deliveryInformationController',
				controllerAs : '$deliveryInformationCtrl'
			}
		});
	
})();