'use strict';
(() => {  
	angular.module('awesome-app.createCustomer')
    .constant('createCustomerRoutes', {
    	//from my understanding this is called from the ui-sref
      createCustomer : {
        url: '/createCustomer',
        templateUrl: '/RestaurantApp/pages/createCustomer.template.html',
        controller: 'CreateCustomerController',
        controllerAs: '$createCustomer'//,
//blocker need to get with Travis for login stuff
/*        data: {
          anonymousAllowed: true,
          loggedIn: false
        }*/
      },
      
      createCustomerSuccess: {
    	  url: '/WINNER_WINNER_BIG_CHICKEN_DINNER/',
    	  templateUrl:'/RestaurantApp/pages/createCustomerSuccess.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      },
      createCustomerFailure: {
    	  url: '/WAT/',
    	  templateUrl: '/RestaurantApp/pages/createCustomerFailure.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      }
      
      
      //need to create a route to show failure.
      
    });
})();