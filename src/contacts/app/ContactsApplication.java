package contacts.app;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

import contacts.resources.ContactServerResource;
import contacts.resources.ContactsServerResource;

/*
 * Contacts list application
 */

public class ContactsApplication extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new instance of HelloWorldResource.
		Router router = new Router(getContext());

		// Defines a finder for a directory of local resources
		Directory directory = new Directory(getContext(), "file:///C:/Users/Jonathan/Documents/dev/restlet/restlet-contacts-app/WebContent/contacts-webapp/app/");
		
		// Defines a route for static files
		router.attach("/static/", directory);
		
		// Defines a route for the resource "list of contacts"	
		router.attach("/contacts", ContactsServerResource.class);
		// Defines a route for the resource "contact"
		router.attach("/contacts/{uuid}", ContactServerResource.class);

		return router;
	}

}
