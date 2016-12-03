'use strict';
(() => {  
	angular.module('awesome-app.createUser')
    .constant('createUserRoutes', {
    	//from my understanding this is called from the ui-sref
      createUser: {
        url: '/pages/',
        templateUrl: 'createUser.template.html',
        controller: 'CreateUserController',
        controllerAs: '$createUser',
//blocker need to get with Travis for login stuff
/*        data: {
          anonymousAllowed: true,
          loggedIn: false
        }*/
      },
      //need to create a route to show success or failure.
      
    });
})();