'use strict';

/* Services */

var contactsServices = angular.module('contactsServices', ['ngResource']);

/*
 * Returns a default angular resource for RESTful interaction with a Contact List entity
 */
contactsServices.factory('Contacts', ['$resource', function($resource){
    return $resource('http://localhost:8182/contactsapp/contacts', {}, {});
  }]);

/*
 * Returns a default angular resource for RESTful interaction with a Contact entity
 */
contactsServices.factory('Contact', ['$resource', function($resource){
	return $resource('http://localhost:8182/contactsapp/contacts/:contactId', {}, {});
}]);

