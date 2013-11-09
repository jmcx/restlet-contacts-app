package contacts.app;

import org.restlet.Component;
import org.restlet.data.Protocol;

/*
 * Main class that starts the HTTP server and runs the contacts application
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {  
	    // Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8182);  

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/contactsapp",  
	            new ContactsApplication());  

	    // Start the component.  
	    component.start();  

	}

}
