package contacts.resources;

/*
 * Java class that defines the contact entity
 */

public class Contact {
	
	String uuid;
	String name;
	Integer age;
	String email;
	
	public Contact(String uuid, String name, Integer age, String email) {
		this.uuid = uuid;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getUuid() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
