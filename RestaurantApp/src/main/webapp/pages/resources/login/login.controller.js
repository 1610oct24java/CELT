'use strict';

(() =>{
	angular.module('awesome-app.login').controller('loginController', loginController);
	
	loginController.$inject = ['loginService'];
	
	function loginController(loginService){
		this.user = {
				userId : 0,
    			firstName : "",
    			lastName : "",
				username : "",
				password : ""
		};
		this.login = () => {
			if(this.user.username == ""){
				alert("Username cannot be empty");
			} else if (this.user.password == ""){
				alert("Password cannot be empty");
			} else {
				loginService.dologin(this.user);
				this.user = {
						username: "",
						password: ""
				};
			};
		}
	}
	
})();