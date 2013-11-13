'use strict';

/* Filters */

/*
 * A filter that returns a checkmark or cross based on a boolean value. 
 */
angular.module('contactsFilters', []).filter('checkmark', function() {
  return function(input) {
    return input ? '\u2713' : '\u2718';
  };
});
