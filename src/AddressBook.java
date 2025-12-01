/*
 * Class: AddressBook
 * Authors: Kevin Lydon and Cameron Hashemi-Pour
 */
import java.io.Serializable;
import java.util.ArrayList;

public class AddressBook implements Serializable {

	ArrayList<ContactList> listList = new ArrayList<ContactList>();

	public AddressBook() {

		ContactList allContacts = new ContactList("All Contacts");
		listList.add(allContacts);
		ContactList friends = new ContactList("Friends");
		listList.add(friends);
		ContactList family = new ContactList("Family");
		listList.add(family);
		ContactList work = new ContactList("Work");
		listList.add(work);

	}

}