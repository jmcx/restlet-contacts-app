'use strict';

/* Controllers */

var contactsControllers = angular.module('contactsControllers', []);

/*
 * Controller for the contact list view.
 * Binds the contact list model to the data in the REST API.
 * Offers a method to create a new contact. 
 * Uses the "Contacts" custom service.
 */
contactsControllers.controller('ContactListCtrl', ['$scope', 'Contacts', 
  function($scope, Contacts) {
	
	/*
	 * Contact list binding, query() accepts a JSON array in response.
	 */
	$scope.contacts = Contacts.query();
	
	/*
	 * Set default ordering strategy.
	 */
	$scope.orderProp = 'age';
	
	/*
	 * Push a new contact to the Web API and update the model
	 */
	$scope.create = function create(user){
		Contacts.save('http://localhost:8182/contactsapp/contacts/',user);
		$scope.contacts.push(user);
	}
	
}]);


/*
 * Controller for the contact details view.
 * Binds the detailed data about a contact to the data in the REST API.
 * Offers a method to delete a contact. 
 * Uses the "Contacts" custom service.
 */
contactsControllers.controller('ContactDetailCtrl', ['$scope', '$routeParams', '$location', 'Contact',
  function($scope, $routeParams, $location, Contact) {
	
	/*
	 * Contact binding, get() requests a single element.
	 */
	$scope.contact = Contact.get({contactId: $routeParams.contactId});
	
	/*
	 * Send a delete contact to the Web API, redirect to the contact list
	 * and update the model.
	 */
	$scope.remove = function remove(){
		Contact.remove({contactId: $routeParams.contactId});
		$location.path("http://localhost:8182/contactsapp/contacts");
		var index = $scope.contacts.indexOf($scope.contact);
		$scope.contacts.splice(index, 1);
	}
	
}]);


