package contacts.resources;

import java.util.HashMap;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ContactsServerResource extends ServerResource implements ContactsResource {

	@Get
	public HashMap<String, Contact> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Post
	public void create(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
