'use strict';

/* App Module */

var contactsApp = angular.module('contactsApp', [
  'ngRoute',
  'contactsControllers'
]);

contactsApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/contacts', {
        templateUrl: 'partials/contact-list.html',
        controller: 'ContactListCtrl'
      }).
      when('/contacts/:uuid', {
        templateUrl: 'partials/contact-detail.html',
        controller: 'ContactDetailCtrl'
      }).
      otherwise({
        redirectTo: '/contacts'
      });
  }]);
