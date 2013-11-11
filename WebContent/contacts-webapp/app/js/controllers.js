'use strict';

/* Controllers */

var contactsApp = angular.module('contactsApp', []);

contactsApp.controller('ContactListCtrl', function ContactListCtrl($scope, $http) {
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
