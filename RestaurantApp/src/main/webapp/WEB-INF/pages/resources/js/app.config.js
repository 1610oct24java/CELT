'use strict';

(() => {
  angular
    .module('awesome-app')
    .config(config);

  config.$inject = ['$locationProvider', '$urlRouterProvider'];

  function config($locationProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/login');
    $locationProvider.html5Mode(true);
  }
})();
