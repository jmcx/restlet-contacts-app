'use strict';

/* jasmine specs for controllers go here */

describe('ContactsManager controllers', function() {
	
	describe('ContactListCtrl', function(){
	    var scope, ctrl, $httpBackend;

	    beforeEach(module('contactsApp'));
	    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
	      $httpBackend = _$httpBackend_;
	      $httpBackend.expectGET('http://localhost:8182/contactsapp/contacts').
	          respond([{name: 'tony'}, {name: 'tom'}]);

	      scope = $rootScope.$new();
	      ctrl = $controller('ContactListCtrl', {$scope: scope});
	    }));


	    it('should create "contacts" model with 2 contacts fetched from xhr', function() {
	      expect(scope.contacts).toBeUndefined();
	      $httpBackend.flush();

	      expect(scope.contacts).toEqual([{name: 'tony'},
	                                   {name: 'tom'}]);
	    });


	    it('should set the default value of orderProp model', function() {
	      expect(scope.orderProp).toBe('age');
	    });
	  });
	});