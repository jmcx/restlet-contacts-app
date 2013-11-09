package contacts.resources;

import java.util.HashMap;

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
		contacts.put("tonyid", new Contact("tonyid", "tony", "tony@email.com"));
		contacts.put("tomid", new Contact("tomid", "tom", "tom@email.com"));
	}

	public Contact retrieve(String uuid) {
		if (contacts == null){
			System.out.println("Contacts null");
		}
		if (contacts.containsKey(uuid)){
			return contacts.get(uuid);
		} else {
			return new Contact("testId", "testName", "testEmail");
		}
	}
	
	public HashMap<String,Contact> retrieveAll(){
		return contacts;
	}

	public void store(Contact contact) {
		contacts.put(contact.getUuid(), contact);
	}

	public void delete(Contact contact) {
		contacts.remove(contact.getUuid());
	}


}
