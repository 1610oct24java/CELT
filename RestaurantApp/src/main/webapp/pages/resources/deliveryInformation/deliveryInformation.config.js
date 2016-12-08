'use strict';

(()=> {
	angular.module('awesome-app.deliveryInformation')
		.config(config)
		
		config.$inject = ['deliveryInformationRoutes', '$stateProvider'];
	
		function config(deliveryInformationRoutes, $stateProvider) {
			Object.key(deliveryInformationRoutes)
				.foreach(key => {
					$stateProvider
						.state(key, deliveryInformationRoutes[key])
				})
		}
})();