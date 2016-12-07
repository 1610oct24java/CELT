'use strict';

(() => {
	angular.module('')
		.service('deliveryInformationService', deliverInformationService)
		
		deliverInformationService.$inject = [ '$http', '$state']
	
		function createContactInfo($http, $state) {
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
		
		
})();