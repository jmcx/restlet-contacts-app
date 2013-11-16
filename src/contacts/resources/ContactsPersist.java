package contacts.resources;

import java.util.HashMap;

/*
 * In memory persistence management class. 
 * Uses the singleton pattern to make sure 
 * there is only one data access object.
 */

public class ContactsPersist {

	private HashMap<String,Contact> contacts;

	private static ContactsPersist instance = null;
	
	protected ContactsPersist() {
		// Exists only to defeat instantiation.
	}
	public static ContactsPersist getInstance() {
		if(instance == null) {
			instance = new ContactsPersist();
			instance.init();
		}
		return instance;
	}

	public void init(){
		this.contacts = new HashMap<String, Contact>();
		contacts.put("tonyid", new Contact("tonyid", "tony", 26, "tony@email.com"));
		contacts.put("tomid", new Contact("tomid", "tom", 40, "tom@email.com"));
	}

	public Contact retrieve(String uuid) {
		if (contacts == null){
			System.out.println("Contacts null");
		}
		if (contacts.containsKey(uuid)){
			return contacts.get(uuid);
		} else {
			// Return a fake contact if the requested ID doesn't exist, should be updated to return a 404 or something
			return new Contact("testId", "testName", 1000, "testEmail");
		}
	}
	
	public HashMap<String,Contact> retrieveAll(){
		return contacts;
	}

	public void store(Contact contact) {
		contacts.put(contact.getUuid(), contact);
	}
	
	public boolean containsContact(String uuid){
		return contacts.containsKey(uuid);
	}

	public void delete(String uuid) {
		contacts.remove(uuid);
	}
	


}
