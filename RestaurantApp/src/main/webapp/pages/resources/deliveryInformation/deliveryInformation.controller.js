'use strict';


(() =>{
	angular.module('awesome-app.di')
		.controller('diController', diController);
		
		diController.$inject = ['diService'];
	
		function diController(diService) {
			this.contactInfo = {
                    id : 0,
					phone : "",
					email : "",
					street :"",
					city : "",
					state : "",
					zip : ""
			}
			
			this.create = () => {
				
				if(this.contactInfo.phone == ""){
					alert("please enter a valid phone number");
					return;
				}else if(this.contactInfo.email == "" ){
					alert("please enter a valid email")
					return;
				}else if(this.contactInfo.street == "") {
					alert("please enter a valid street address")
					return;
				}else if (this.contactInfo.city == "") {
					alert("please enter a valid City")
					return;
				}else if (this.contactInfo.state == "") {
					alert("please enter a valid State") 
					return;
				}else if(this.contactInfo.zip == "") {
					alert("please enter a valid Zip")
					return;
				}else {
					console.log(this.contactInfo);
					diService.createContactInfo(this.contactInfo);
					this.contactInfo = {
		                    id : 0,
							phone : "",
							email : "",
							street :"",
							city : "",
							state : "",
							zip : ""
					}
				}
	
				
			}
		};
})();