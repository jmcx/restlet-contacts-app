package contacts.resources;

import org.json.*;
import org.restlet.data.Status;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import contacts.utils.JsonUtils;

/*
 * Server resource that corresponds to a single contact entity
 */

public class ContactServerResource extends ServerResource {
	
	@Get("json")
	public StringRepresentation toJson() {
		String uuid = (String) getRequest().getAttributes().get("uuid");
		return JsonUtils.representContactJson(ContactsPersist.getInstance().retrieve(uuid));
	}
	
	@Put("json")
	public void storeJson(String value) {
		JSONObject o = new JSONObject(value);
		String uuid = o.getString("uuid");
		// Only update the contact if it exists, don't create a new one
		if (ContactsPersist.getInstance().containsContact(uuid)){ 
			Contact c = new Contact(o.getString("uuid"), o.getString("name"), o.getInt("age"), o.getString("email"));
			ContactsPersist.getInstance().store(c);
			setStatus(Status.SUCCESS_CREATED);
		} else {
			setStatus(Status.SUCCESS_OK);
		}
	}

	@Delete
	public void remove() {
		String uuid = (String) getRequest().getAttributes().get("uuid");
		ContactsPersist.getInstance().delete(uuid);
		// Tells the client that the request has been successfully fulfilled.
        setStatus(Status.SUCCESS_NO_CONTENT);
	}
}
