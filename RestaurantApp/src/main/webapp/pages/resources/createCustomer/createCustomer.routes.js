'use strict';
(() => {  
	angular.module('awesome-app.createCustomer')
    .constant('createCustomerRoutes', {
      createCustomer : {
        url: '/createCustomer',
        templateUrl: '/RestaurantApp/resources/createCustomer/createCustomer.template.html',
        controller: 'CreateCustomerController',
        controllerAs: '$createCustomer'//,
        	//blocker need to get with Travis for login stuff
        	/*        data: {
          anonymousAllowed: true,
          loggedIn: false
        }*/
      },
      
      createCustomerSuccess: {
    	  url: '/WINNER_WINNER_CHICKEN_NUGGET_DINNER/',
    	  templateUrl:'/RestaurantApp/resources/createCustomer/createCustomerSuccess.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      },
      createCustomerFailure: {
    	  url: '/WAT/',
    	  templateUrl: '/RestaurantApp/resources/createCustomer/createCustomerFailure.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      }
      
      
      //need to create a route to show failure.
      
    });
})();