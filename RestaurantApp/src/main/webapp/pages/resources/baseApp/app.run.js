'use strict';

(() => {

  angular
    .module('awesome-app')
    //i like using the using the var.$inject property to do my D.I.
    .run(run);

    run.$inject = ['$rootScope'
  //need to get with with travis and show him login angular login way (which imo should with bcrypt
  //  	, 'loginService'
    	, '$state'];

    function run($rootScope
    	//	, loginService
    		, $state) {
      $rootScope.$on('$stateChangeStart', function(event, toState, toStateParams){

//      let anonymousAllowed = toState.data.anonymousAllowed;
//      let loggedIn = personService.isLoggedIn();

//		if(!loggedIn){
//   		event.preventDefault();$state.go('login')
// 		}
      });
    }
})();