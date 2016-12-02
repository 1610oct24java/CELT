'use strict';

(() => {
	  angular
	    .module('awesome-app.createUser')
	    .service('createUserService', CreateUserService);

	    CreateUserService.$inject = [ '$http' ];
     //get with scrum master to connect front to back end.
	    function CreateUserService($http) {
	    	 this.create = function (user) {
	    	        return $http
	    	          .post('/createUser', user)
	    	          .then(response => response.data)
	    	      }
	    }
})();	    