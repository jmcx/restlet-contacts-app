package contacts.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import org.json.JSONObject;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

import contacts.app.ContactsApplication;
import contacts.resources.Contact;
import contacts.utils.JsonUtils;

import org.junit.Assert;

public class TestMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8182);
	    // For access to local static files (web application)
	    component.getClients().add(Protocol.FILE); 
	    

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/contactsapp",  
	            new ContactsApplication());  

	    // Start the component.  
	    component.start();  
	    
	    // Test adding a new resource
	    
	    Contact contact = new Contact("UnitTestUuid", "UnitTestName", 404, "UnitTestEmail");
	    
	    new ClientResource("http://localhost:8182/contactsapp/contacts").post(JsonUtils.representContactJson(contact), MediaType.APPLICATION_JSON);
	  
		Reference resourceRef = new Reference("http://localhost:8182/contactsapp/contacts/UnitTestUuid");
		Client client2 = new Client(Protocol.HTTP);
		Request request = new Request(Method.GET, resourceRef);
		Response response = client2.handle(request);

		assert response.getStatus().getCode() == 200;
		assert response.isEntityAvailable();
		assert response.getEntity().getMediaType().equals(MediaType.APPLICATION_JSON);

		// Representation.getText() empties the InputStream, so we need to store the text in a variable
		String text = response.getEntity().getText();
		
		JSONObject o = new JSONObject(text);
		Contact c = new Contact(o.getString("uuid"), o.getString("name"), o.getInt("age"), o.getString("email"));
				
		org.junit.Assert.assertEquals(c.getUuid(), "UnitTestUuid");
		org.junit.Assert.assertEquals(c.getName(), "UnitTestName");
	    org.junit.Assert.assertEquals(c.getAge(),405);
	    org.junit.Assert.assertEquals(c.getEmail(), "UnitTestEmail");

	}

}
