package contacts.resources;

import org.json.*;
import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import contacts.utils.JsonUtils;

public class ContactServerResource extends ServerResource {
	
	@Get("json")
	public StringRepresentation toJson() {
		String uuid = (String) getRequest().getAttributes().get("uuid");
		return JsonUtils.representContactJson(ContactsPersist.getInstance().retrieve(uuid));
	}
	
//	@Get("jpeg")
//    public FileRepresentation toJpeg() {
//		SSystem.out.println("toHtml");
//		String uuid = (String) getRequest().getAttributes().get("uuid");
//		//		System.out.println("Get HTML");
//		System.out.println("uudi: " + uuid);
//		return representHtml(ContactsPersist.getInstance().retrieve(uuid));
//    }
	
	
	@Put("json")
	public void storeJson(String value) {
		System.out.println("Put");
		JSONObject o = new JSONObject(value);
		System.out.println(o.getString("uuid"));
		Contact c = new Contact(o.getString("uuid"), o.getString("name"), o.getString("email"));
		ContactsPersist.getInstance().store(c);
	}

//	@Put("jpeg")
//	public void storeJpeg(Contact contact) {
//		//ContactServerResource.contact = contact;		
//	}

	@Delete
	public void remove() {
		//contact = null;		
	}
}
