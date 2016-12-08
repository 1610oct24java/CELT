'use strict';

(() => {
	angular.module('awesome-app.deliveryInformation')
		.service('deliveryInformationService', deliveryInformationService)
		
		deliveryInformationService.$inject = [ '$http', '$state']
	
		function deliveryInformationService($http, $state) {
			function createContactInfo() {
				this.info = {};
					$http
						.post('/addContactInfo', contactInfo)
						.then(response => response.data)
						.then(contactInfo => {
							console.log(contactInfo);
							this.info = contactInfo;
						})
						
					if(info == null){
						return $state.go('');
					}else {
						return $state.go('');
					}
				
			}
		
		}
})();