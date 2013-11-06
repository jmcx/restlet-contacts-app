package contacts.resources;

public interface ContactDAO {
	Contact retrieve(String uuid);
	void update(Contact contact);
	void create(Contact contact);
	void delete(Contact contact);
}
