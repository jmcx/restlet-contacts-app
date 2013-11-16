package contacts.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

import org.restlet.ext.json.JsonRepresentation;

import contacts.resources.Contact;

public class JsonUtils {

	public static JsonRepresentation representContactJson(Contact contact){
		return new JsonRepresentation(contactDetailToJson(contact));
	}

	public static JsonRepresentation representContactsJson(ConcurrentMap<String,Contact> contacts){
		String s = "[ ";
		Collection<Contact> values = contacts.values();
		for (Iterator<Contact> iterator = values.iterator(); iterator.hasNext();) {
			Contact c = (Contact) iterator.next();
			s += contactSnippetToJson(c);
			if (iterator.hasNext()){
				s += ",";
			}	
		}
		s+= " ]";

		return new JsonRepresentation(s);
	}

	private static String contactSnippetToJson(Contact contact){
		return "{ \"uuid\": \"" + contact.getUuid() + "\", \"name\": \"" + contact.getName() + "\", \"age\": " + contact.getAge() + ", \"details\": \"/" + contact.getUuid() + "\" }";
	}
	
	private static String contactDetailToJson(Contact contact){
		return "{ \"uuid\": \"" + contact.getUuid() + "\", \"name\": \"" + contact.getName() + "\", \"age\": " + contact.getAge() + ", \"email\": \"" + contact.getEmail() + "\" }";
	}
}
