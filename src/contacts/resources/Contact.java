package contacts.resources;

public class Contact {
	
	String uuid;
	String name;
	String email;
	
	public Contact(String id, String name, String email) {
		this.uuid = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return uuid;
	}

	public void setId(String id) {
		this.uuid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
