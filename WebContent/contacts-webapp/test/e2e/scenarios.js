'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('ContactManager App', function() {

	  describe('Contact list view', function() {

	    beforeEach(function() {
	      browser().navigateTo('app/index.html');
	    });


	    it('should filter the contact list as user types into the search box', function() {
	      expect(repeater('.contacts li').count()).toBe(3);

	      input('query').enter('yahoo');
	      expect(repeater('.contacts li').count()).toBe(1);

	      input('query').enter('gmail');
	      expect(repeater('.contacts li').count()).toBe(2);
	    });
	  });
	});
