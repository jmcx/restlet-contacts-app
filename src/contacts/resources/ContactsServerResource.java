package contacts.resources;


import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import contacts.utils.*;

public class ContactsServerResource extends ServerResource {

//	@Get
//    public String represent() {
//        return "" + contact.getName() + ", " + contact.getEmail();
//    }
	
	@Get("json")
	public StringRepresentation toJson() {
		return JsonUtils.representContactsJson(ContactsPersist.getInstance().retrieveAll());
	}

	@Post
	public void create(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
