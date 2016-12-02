'use strict';

(()=>{

  angular
    .module('awesome-app.createUser')
    .config(config)

    config.$inject = ['createUserRoutes', '$stateProvider']

    function config(createUserRoutes, $stateProvider) {
      Object.keys(createUserRoutes) // JS built in function
        .forEach(key => {
          $stateProvider
            .state(key, createUserRoutes[key]);  //accesses each state object given the key and the object
        })
    }

})();
