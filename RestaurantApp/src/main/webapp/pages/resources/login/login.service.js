'use strict';

(() => {
	angular.module('awesome-app.login').service('loginService', loginService);
	
	loginService.$inject = ['$http', '$state'];
	
	function loginService($http, $state) {
		this.dologin = user => {
			console.log(user);
			$http.post('login', user)
			.then(response => response.data)
			.then(destination => {
				console.log(destination);
				if(destination =="manager") {
					$state.go('managerRoute');
				}else if(destination == "customer") {
					$state.go('customerRoute');
				} else {
					$state.go('login');
				}
			});
			
			
		}
		
		
	}
})();

