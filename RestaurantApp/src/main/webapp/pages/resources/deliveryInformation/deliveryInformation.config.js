'use strict';

(()=>{
	angular.module('awesome-app.di')
		.config(configuration)
		
		configuration.$inject = ['diRoutes', '$stateProvider']
	
		function configuration(diRoutes, $stateProvider) {
			Object.keys(diRoutes)
				.forEach(key => {
					$stateProvider
						.state(key, diRoutes[key])
				});
		}
})();