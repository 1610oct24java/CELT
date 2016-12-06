/*global
	app
*/

app.directive('editMenu', function () {
    'use strict';
    return {
        restrict: 'E',
        scope: {},
        templateUrl: "editMenu.html",
        link: function (scope, element, attrs) {
            scope.buttonText = "Edit";
            scope.editing = false;
            scope.edit = function () {
                element.toggleClass('btn-active');
                if (scope.editing) {
                    scope.buttonText = "Edit";
                    scope.editing = false;
                } else {
                    scope.buttonText = "Cancel Edit";
                    scope.editing = true;
                }
            };
        }
    };
});