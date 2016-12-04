'use strict';
(() => {  
	angular.module('awesome-app.createCustomer')
    .constant('createCustomerRoutes', {
    	//from my understanding this is called from the ui-sref
      createCustomer : {
        url: '/pages/',
        templateUrl: 'createCustomer.template.html',
        controller: 'CreateCustomerController',
        controllerAs: '$createCustomer'//,
//blocker need to get with Travis for login stuff
/*        data: {
          anonymousAllowed: true,
          loggedIn: false
        }*/
      },
      
      createCustomerSuccess: {
    	  url: '/pages/',
    	  templateUrl:'createCustomerSuccess.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      },
      createCustomerFailure: {
    	  url: '/pages/',
    	  templateUrl: 'createCustomerFailure.template.html',
    	  controller: 'CreateCustomerController',
    	  controllerAs: '$createCustomer'
      }
      
      
      //need to create a route to show failure.
      
    });
})();