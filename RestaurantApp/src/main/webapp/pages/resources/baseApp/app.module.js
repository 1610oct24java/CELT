'use strict';

(() => {
  angular
    .module('awesome-app'
    	, ['ui.router'
    	, 'ui.bootstrap'
    	, 'awesome-app.di'
    	, 'awesome-app.createCustomer'
    	, 'awesome-app.login'
    ]);
}
)();
