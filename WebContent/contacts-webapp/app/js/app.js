'use strict';

/* App Module */

/*
 * Declare all the application's dependencies
 */
var contactsApp = angular.module('contactsApp', [
  'ngRoute',
  'contactsControllers',
  'contactsFilters',
  'contactsServices'
]);

/*
 * Create routes for contact list and contact details 
 * and attach corresponding views and controllers
 */
contactsApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/contacts', {
        templateUrl: 'partials/contact-list.html',
        controller: 'ContactListCtrl'
      }).
      when('/contacts/:contactId', {
        templateUrl: 'partials/contact-detail.html',
        controller: 'ContactDetailCtrl'
      }).
      otherwise({
        redirectTo: '/contacts'
      });
  }]);
