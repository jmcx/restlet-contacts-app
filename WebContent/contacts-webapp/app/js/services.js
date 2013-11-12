'use strict';

/* Services */

var contactsServices = angular.module('contactsServices', ['ngResource']);

//contactsServices.factory('Contacts', ['$resource', function($resource){
//    return $resource('http://localhost:8182/contactsapp/:contactId', {}, {
//    	query: {method:'GET', params:{contactId:'contacts'}, isArray:true}
//    });
//  }]);

contactsServices.factory('Contacts', ['$resource', function($resource){
    return $resource('http://localhost:8182/contactsapp/contacts', {}, {
    	query: {method:'GET', params:{}, isArray:true}
//    	store: {method: 'POST', params:{uuid:''}}
//    	query: {method:'GET', {}, isArray:true}
    });
  }]);

contactsServices.factory('Contact', ['$resource', function($resource){
	return $resource('http://localhost:8182/contactsapp/contacts/:contactId', {}, {
//		query: {method:'GET', params:{contactId:'contacts'}, isArray:true}
	});
}]);












//,
//querySingle: {method:'GET', params:{contactId:'contacts/'{{contact.uuid}}}, isArray:true}