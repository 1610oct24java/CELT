'use strict';

(() => {
	  angular
	    .module('awesome-app.createCustomer')
	    .service('createCustomerService', CreateCustomerService);

	    CreateCustomerService.$inject = [ '$http' ];
     //get with scrum master to connect front to back end.
	    function CreateCustomerService($http) {
	    	 this.create = (customer) => {
	    	        return $http
	    	          .post('/createCustomer', customer)
	    	          .then(response => response.data)
	    	          .then(customer => 
	    	          	customer == null ? $state.go('createCustomerFailure')
	    	          		 : $state.go('createCustomerSuccess'))
	    	      };
	    }
})();	    