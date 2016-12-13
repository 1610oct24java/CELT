'use strict';

(() =>{
	angular.module('awesome-app.login')
		.config(config);
	
	config.$inject = ['loginRoutes', '$stateProvider']
	
	function config(loginRoutes, $stateProvider){
		Object.keys(loginRoutes)
			.forEach(key => {
				   $stateProvider
		            .state(key, loginRoutes[key]);
			})
	}
})();