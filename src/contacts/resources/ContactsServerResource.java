package contacts.resources;


import org.json.JSONObject;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import contacts.utils.*;

/*
 * Resource corresponding to a list of contact entities.
 */

public class ContactsServerResource extends ServerResource {
	
	@Get("json")
	public StringRepresentation toJson() {
		return JsonUtils.representContactsJson(ContactsPersist.getInstance().retrieveAll());
	}

	@Post("json")
	public void create(String value) {
		JSONObject o = new JSONObject(value);
		if (!ContactsPersist.getInstance().containsContact(o.getString("uuid"))){
			Contact c = new Contact(o.getString("uuid"), o.getString("name"), o.getInt("age"), o.getString("email"));
			ContactsPersist.getInstance().store(c);
		}
	}

}
