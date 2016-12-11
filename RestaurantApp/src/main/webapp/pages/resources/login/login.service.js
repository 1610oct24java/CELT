'use strict';

(() => {
	angular.module('awesome-app.login').service('loginService', loginService);
	
	loginService.$inject = ['$http', '$state'];
	
	function loginService($http, $state) {
		this.dologin =(user)=> {
			this.dest = "";
			$http.post('login', user)
			.then(response => response.data)
			.then(destination => {
				dest = destination;
			});
			
			if(dest =="manager") {
				$state.go('managerRoute');
			}else {
				$state.go('customerRoute');
			}
		}
		
		
	}
})();

