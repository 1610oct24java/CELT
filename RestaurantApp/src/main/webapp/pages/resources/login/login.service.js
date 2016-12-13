'use strict';

(() => {
	angular.module('awesome-app.login').service('loginService', loginService);
	
	loginService.$inject = ['$http', '$state'];
	
	function loginService($http, $state) {
		this.dologin = user => {
		
			$http.post('login', user)
			.then(response => response.data)
			.then(destination => {
				console.log(destination);
				if(typeof destination.restaurant == 'object') {
					console.log(destination.restaurant);
					console.log("WAT");
					$state.go('managerRoute');
				}else if(typeof destination.firstName == 'string') {
					$state.go('customerRoute');
				} else {
					$state.go('login');
				}
				console.log('done');
			});
			
			
		}
		
		
	}
})();

