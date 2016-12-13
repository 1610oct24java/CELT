'use strict';

(() => {
	  angular
	    .module('awesome-app.createCustomer')
	    .service('createCustomerService', CreateCustomerService);

	    CreateCustomerService.$inject = [ '$http', '$state'];

	    function CreateCustomerService($http, $state) {	  
	    	 this.create = (customer) => {
	    	       $http //note because of the => syntax the return is implied
	    	        .post('cCustomer', customer)
	    	          .then(response => response.data)
	    	          .then(customer => {
	    	        	  customer.id == null ? $state.go('createCustomerFailure')
    	          		 : $state.go('createCustomerSuccess')        
	    	      })
	    	 }
	    } 	   	
	    
})();	    