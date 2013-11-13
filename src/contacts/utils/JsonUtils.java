package contacts.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;

import contacts.resources.Contact;

public class JsonUtils {

	public static StringRepresentation representContactJson(Contact contact){
		return new StringRepresentation(contactDetailToJson(contact), MediaType.APPLICATION_JSON);
	}

	public static StringRepresentation representContactsJson(HashMap<String,Contact> contacts){
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

		return new StringRepresentation(s, MediaType.APPLICATION_JSON);
	}

	private static String contactSnippetToJson(Contact contact){
		return "{ \"uuid\": \"" + contact.getUuid() + "\", \"name\": \"" + contact.getName() + "\", \"age\": " + contact.getAge() + ", \"details\": \"/" + contact.getUuid() + "\" }";
	}
	
	private static String contactDetailToJson(Contact contact){
		return "{ \"uuid\": \"" + contact.getUuid() + "\", \"name\": \"" + contact.getName() + "\", \"age\": " + contact.getAge() + ", \"email\": \"" + contact.getEmail() + "\" }";
	}
}
