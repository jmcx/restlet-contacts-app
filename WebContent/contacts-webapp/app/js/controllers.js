'use strict';

/* Controllers */

var contactsControllers = angular.module('contactsControllers', []);

contactsControllers.controller('ContactListCtrl', ['$scope', 'Contacts', 
  function($scope, Contacts) {
	$scope.contacts = Contacts.query();
	
	$scope.orderProp = 'age';
	
	$scope.create = function create(user){
		Contacts.save('http://localhost:8182/contactsapp/contacts/',user);
		$scope.contacts += user;
		$scope.contacts = Contacts.query();
	}
	
}]);

contactsControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', '$location', 'Contact',
  function($scope, $routeParams, $location, Contact) {
	
	$scope.contact = Contact.get({contactId: $routeParams.contactId});
	
	$scope.remove = function remove(){
		Contact.remove({contactId: $routeParams.contactId});
		$location.path("http://localhost:8182/contactsapp/contacts");
//		$scope.contacts.splice( $scope.contacts.indexOf($routeParams.contactId), 1 );
	}
	
}]);





















//contactsControllers.controller('ContactListCtrl', function ContactListCtrl($scope, $http) {
//$http.get('http://localhost:8182/contactsapp/contacts').
//success(function(data) {
//	$scope.contacts = data;
//})
//.error(function(data, status, headers, config) {
//	confirm("error: " + status);
//	// called asynchronously if an error occurs
//	// or server returns response with an error status.
//	});
//
//$scope.orderProp = 'age';
//});


//contactsControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {
//	$http.get('http://localhost:8182/contactsapp/contacts/' + $routeParams.uuid).
//	success(function(data) {
//		$scope.contact = data;
//	})
//	.error(function(data, status, headers, config) {
//		confirm("error: " + status);
//		// called asynchronously if an error occurs
//		// or server returns response with an error status.
//		});
//}]);