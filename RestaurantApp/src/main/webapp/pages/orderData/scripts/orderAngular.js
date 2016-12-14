'use strict';

var app = angular.module('app', []);

app.controller('OrderCtrl', function($http){
	let order;
	$http.get('')
		.then(response => response.data)
		.then(order =>{
			console.log(order);
			order = order});
			
	
});