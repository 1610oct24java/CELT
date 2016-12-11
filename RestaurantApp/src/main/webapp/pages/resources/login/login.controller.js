'use strict';

(() =>{
	angular.module('awesome-app.login').controller('loginController', loginController);
	
	loginController.$inject = ['loginService'];
	
	function loginController(loginService){
		this.user = {
				username : "",
				password : ""
		};
		this.login = () => {
			if(username == ""){
				alert("Username cannot be empty");
			} else if (password == ""){
				alert("Password cannot be empty");
			} else {
				loginService.dologin(user);
				user = {
						username: "",
						password: ""
				};
			};
		}
	}
	
})();