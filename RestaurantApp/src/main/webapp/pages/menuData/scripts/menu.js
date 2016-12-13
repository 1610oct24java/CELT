/*global
	app
*/

//menu display directive
app.directive('menuInfo', function () {
    'use strict';
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        template: '<td>{{ restaurant }}</td>'
    };
});