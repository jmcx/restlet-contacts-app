package contacts.resources;

import java.util.HashMap;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ContactsResource {
	@Get
    public HashMap<String,Contact> retrieve();

    @Post
    public void create(Contact contact);

}
