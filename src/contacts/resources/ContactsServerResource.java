package contacts.resources;


import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
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
	public Representation create(String value) {
		Representation result = null;
		JSONObject o = new JSONObject(value);
		String uuid = o.getString("uuid");
		if (!ContactsPersist.getInstance().containsContact(uuid)){
			Contact c = new Contact(uuid, o.getString("name"), o.getInt("age"), o.getString("email"));
			ContactsPersist.getInstance().store(c);
			// Set the response's status and entity
			setStatus(Status.SUCCESS_CREATED);
			Representation rep = new StringRepresentation("Item created",
					MediaType.TEXT_PLAIN);
			// Indicates where is located the new resource.
			rep.setLocationRef(getRequest().getResourceRef().getIdentifier()
					+ "/" + uuid);
			result = rep;
		} else {
			setStatus(Status.CLIENT_ERROR_NOT_FOUND);
			result = generateErrorRepresentation("Contact with uuid '" + uuid
					+ "' already exists.", "1");
		}
		return result;
	}
	
	/**
	 * Generate a string representation of an error response.
	 * 
	 * @param errorMessage
	 *            the error message.
	 * @param errorCode
	 *            the error code.
	 */
	private Representation generateErrorRepresentation(String errorMessage, String errorCode) {
		
		Representation result = new StringRepresentation("Error: " + errorMessage + " Error code: " + errorCode, MediaType.TEXT_PLAIN);
		return result;
	}
}
