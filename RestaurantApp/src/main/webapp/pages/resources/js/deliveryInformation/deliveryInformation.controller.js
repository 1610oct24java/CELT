'use strict';


(() =>{
	angular.module('awesome-app.deliveryInformation')
		.controller('deliveryInformationController', deliveryInformationController)
		
		deliveryInformationController.$inject = ['deliveryInformationService'];
	
		deliveryInformationService => {
			this.contactInfo = {
                    ID : 0,
					Phone : "",
					Email : "",
					Street :"",
					City : "",
					State : "",
					Zip : ""
			}
			this.create = () => {
				
				if(this.contactInfo.Phone == ""){
					alert("please enter a valid phone number");
					return;
				}else if(this.contactInfo.Email == "" ){
					alert("please enter a valid email")
					return;
				}else if(this.contactInfo.Street == "") {
					alert("please enter a valid street address")
					return;
				}else if (this.contactInfo.City == "") {
					alert("please enter a valid City")
					return;
				}else if (this.contactInfo.State == "") {
					alert("please enter a valid State") 
					return;
				}else if(this.contactInfo.Zip == "") {
					alert("please enter a valid Zip")
					return;
				}else {
					deliveryInformationService.createContactInfo(contactInfo);
				}
				
				this.contactInfo = {
	                    ID : 0,
						Phone : "",
						Email : "",
						Street :"",
						City : "",
						State : "",
						Zip : ""
				}
				
			}
		};
})();