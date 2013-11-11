'use strict';

/* Controllers */

var contactsControllers = angular.module('contactsControllers', []);

contactsControllers.controller('ContactListCtrl', function ContactListCtrl($scope, $http) {
	$http.get('http://localhost:8182/contactsapp/contacts').
	success(function(data) {
		$scope.contacts = data;
	})
	.error(function(data, status, headers, config) {
		confirm("error: " + status);
		// called asynchronously if an error occurs
		// or server returns response with an error status.
		});

	$scope.orderProp = 'age';
});

contactsControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', function($scope, $routeParams) {
	$scope.uuid = $routeParams.uuid;
}]);