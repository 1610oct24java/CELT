'use strict';

(() => {
  angular
    .module('awesome-app.createCustomer')
    .controller('CreateCustomerController', CreateCustomerController);
    
  		CreateCustomerController.$inject = ['createCustomerService', '$state'];

    function CreateCustomerController(createCustomerService, $state) {
    	this.customer = {
    			firstName : "",
    			lastName : "",
    			username : "",
    			password : ""
    			}
      this.create = () => {
    	if(this.customer.firstName == ""){
    		alert("First Name is Required");
    		return;
    	} else if (this.customer.lastName == "")
    	{
    		alert("Last Name is Required");
    		return;
    	} else if (this.user.username == "")
    	{
    		alert("Username is Required");
    		return;
    	} else if(this.customer.password == "") {
    		alert("Password is Required");
    		return;
    	} else {
        createCustomerService
        .create(this.customer)
        this.customer = {
  		  firstName : "",
			lastName : "",
			username : "",
			password : ""  
    }
  }
        }
      }
     
})();