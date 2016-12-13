'use strict';

(() => {
  angular
    .module('awesome-app')
    .config(config);

  config.$inject = ['$locationProvider', '$urlRouterProvider'];

  function config($locationProvider, $urlRouterProvider) {
    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise('/home');
  }
})();
