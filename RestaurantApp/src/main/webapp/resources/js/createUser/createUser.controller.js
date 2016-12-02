'use strict';

(() => {
  angular
    .module('awesome-app.createUser')
    .controller('CreateUserController', CreateUserController);
  	//I hope Friday I'll be able to connect my front end to the back-end 
  	//without the use of restController or even with the use of annotation driven
    //Spring as I've have some (but very little experience with it.
    CreateUserController.$inject = ['createUserService', '$state'];

    function CreateUserController(createUserService, $state) {
      this.create = () => {
        createUserService
        .create(this.user)
        .then((createdUser) => {
          $state.go('createdUserSuccess', {username: createdUser.username});
        });
      }
    }


})();