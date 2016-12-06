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
	    	        	  customer == null ? $state.go('createCustomerFailure', {method: "GET"})
	    	          		 : $state.go('createCustomerSuccess',{method:"GET"})        
	    	      })
	    	 }
	    } 	   	
	    
})();	    