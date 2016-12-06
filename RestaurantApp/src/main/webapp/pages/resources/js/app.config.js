'use strict';

(() => {
  angular
    .module('awesome-app')
    .config(config);

  config.$inject = ['$locationProvider', '$urlRouterProvider'];

  function config($locationProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise(""+ base + "/pages/login.html");
    $locationProvider.html5Mode(true);
  }
})();
