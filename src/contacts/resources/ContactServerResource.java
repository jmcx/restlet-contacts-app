package contacts.resources;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class ContactServerResource extends ServerResource implements ContactResource{
	
	private static volatile Contact contact = 
        new Contact("id1", "James", "james@email.com");
	
	@Get
    public String represent() {
        return "" + contact.getName() + ", " + contact.getEmail();
    }

    
	public Contact retrieve() {
		return contact;
	}

	@Put
	public void store(Contact contact) {
		ContactServerResource.contact = contact;		
	}

	@Post
	public void create(Contact contact) {
		
	}
	
	@Delete
	public void remove() {
		contact = null;		
	}

	
}
