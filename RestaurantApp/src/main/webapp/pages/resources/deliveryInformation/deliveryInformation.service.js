'use strict';

(() => {
	angular.module('awesome-app.di')
		.service('diService', diService);
		
		diService.$inject = [ '$http', '$state'];
	
		function diService($http, $state) {
			this.createContactInfo = contactInfo =>  {
					$http
						.post('addContactInfo', contactInfo)
						.then(response => response.data)
						.then(contactInfo => {
							if(contactInfo == null){
								$state.go('createDeliveryInformationFailure');
								} else {
									$state.go('createDeliveryInformationSuccess');
								}
						});
		
			}
			
		
		}
})();