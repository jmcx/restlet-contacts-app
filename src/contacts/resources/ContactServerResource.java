package contacts.resources;

import org.json.*;
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
		Contact c = new Contact(o.getString("uuid"), o.getString("name"), o.getInt("age"), o.getString("email"));
		ContactsPersist.getInstance().store(c);
	}

	@Delete
	public void remove() {
		String uuid = (String) getRequest().getAttributes().get("uuid");
		ContactsPersist.getInstance().delete(uuid);
	}
}
