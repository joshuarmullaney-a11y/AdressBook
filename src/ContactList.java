import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable {

	public String listName;
	public ArrayList<Contact> contactList = new ArrayList<Contact>();

	public ContactList(String l) {

		listName = l;

	}

	public void addContact(Contact c) {
		contactList.add(c);
	}

	public void removeContact(Contact c) {
		contactList.remove(c);
	}

	public int getSize() {
		return contactList.size();
	}

	public Contact getContact(int index) {
		return contactList.get(index);
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

}
