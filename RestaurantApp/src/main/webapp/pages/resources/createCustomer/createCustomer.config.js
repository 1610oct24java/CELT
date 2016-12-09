'use strict';

(()=>{

  angular
    .module('awesome-app.createCustomer')
    .config(config)
    
    config.$inject = ['createCustomerRoutes', '$stateProvider']

    function config(createCustomerRoutes, $stateProvider) {
      Object.keys(createCustomerRoutes) // JS built in function
        .forEach(key => {
          $stateProvider
            .state(key, createCustomerRoutes[key]);  // accesses each state
														// object given the key
														// and the object
        })
    }

})();
