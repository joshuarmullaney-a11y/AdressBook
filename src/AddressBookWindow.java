import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AddressBookWindow extends JFrame implements ActionListener,
		ListSelectionListener {

	AddressBook addressBook;

	JButton addButton = new JButton("Add");
	JButton editButton = new JButton("View/Edit");
	JButton deleteButton = new JButton("Delete");
	JButton saveButton = new JButton("Save + Exit");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem close = new JMenuItem("Close");

	DefaultListModel listsModel = new DefaultListModel();
	JList lists = new JList(listsModel);
	DefaultListModel contactModel = new DefaultListModel();
	JList contactJList = new JList(contactModel);
	JTextArea infoArea = new JTextArea();

	public AddressBookWindow(AddressBook a) {

		addressBook = a;

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		save.addActionListener(this);
		close.addActionListener(this);
		file.add(save);
		file.add(close);
		menuBar.add(file);
		this.setJMenuBar(menuBar);

		JPanel listsPanel = new JPanel();
		listsPanel.setLayout(new BorderLayout());

		lists.addListSelectionListener(this);
		lists.setCellRenderer(new ContactListRenderer());
		JScrollPane listPane = new JScrollPane(lists);
		listPane.setPreferredSize(new Dimension(150, 250));
		listPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listsPanel.add(listPane, BorderLayout.WEST);

		contactJList.addListSelectionListener(this);
		contactJList.setCellRenderer(new ContactRenderer());
		JScrollPane contactsPane = new JScrollPane(contactJList);
		contactsPane.setPreferredSize(new Dimension(150, 250));
		contactsPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listsPanel.add(contactsPane, BorderLayout.EAST);

		this.add(listsPanel, BorderLayout.WEST);

		JScrollPane infoPane = new JScrollPane(infoArea);
		infoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(infoPane, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		addButton.addActionListener(this);
		editButton.addActionListener(this);
		deleteButton.addActionListener(this);
		saveButton.addActionListener(this);
		buttons.add(addButton);
		buttons.add(editButton);
		buttons.add(deleteButton);
		buttons.add(saveButton);
		this.add(buttons, BorderLayout.SOUTH);

		for (ContactList c : addressBook.listList) {
			listsModel.add(listsModel.getSize(), c);

		}

		this.setTitle("Address Book");

		this.setSize(500, 400);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == addButton) {
			ContactEditor editor = new ContactEditor(addressBook);
		}
		if (source == editButton) { // Add code for edit
			if (contactJList.getSelectedIndex() == -1) {

			} else {
				ContactEditor editor = new ContactEditor(
						addressBook,
						addressBook.listList.get(lists.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()));
			}
		}
		if (source == deleteButton) { // Add code for delete
			if (lists.getSelectedIndex() == 0) {

				if (addressBook.listList.get(1).contactList
						.contains(addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()))) {
					addressBook.listList.get(1).contactList
							.remove(addressBook.listList.get(lists
									.getSelectedIndex()).contactList
									.get(contactJList.getSelectedIndex()));
				}

				if (addressBook.listList.get(2).contactList
						.contains(addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()))) {
					addressBook.listList.get(2).contactList
							.remove(addressBook.listList.get(lists
									.getSelectedIndex()).contactList
									.get(contactJList.getSelectedIndex()));
				}

				if (addressBook.listList.get(3).contactList
						.contains(addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()))) {
					addressBook.listList.get(3).contactList
							.remove(addressBook.listList.get(lists
									.getSelectedIndex()).contactList
									.get(contactJList.getSelectedIndex()));
				}
				addressBook.listList.get(0).contactList
						.remove(addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()));
				contactModel.clear();
				for (Contact b : addressBook.listList.get(lists
						.getSelectedIndex()).contactList) {
					contactModel.add(contactModel.getSize(), b);
				}
				infoArea.setText("");
			} else {
				addressBook.listList.get(lists.getSelectedIndex()).contactList
						.remove(addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex()));
				contactModel.clear();
				for (Contact b : addressBook.listList.get(lists
						.getSelectedIndex()).contactList) {
					contactModel.add(contactModel.getSize(), b);
				}
				infoArea.setText("");
			}
		}
		if (source == saveButton) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream("MyAddressBook"));
				oos.writeObject(addressBook);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.exit(0);
		}
		if (source == save) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream("MyAddressBook"));
				oos.writeObject(addressBook);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (source == close) {
			System.exit(0);
		} else {

		}

	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (e.getValueIsAdjusting() == false) {

			if (lists.getSelectedIndex() == -1) {

			} else {
				if (source == lists) {
					contactModel.clear();
					for (Contact b : addressBook.listList.get(lists
							.getSelectedIndex()).contactList) {
						contactModel.add(contactModel.getSize(), b);
					}
				} else {

					if (contactJList.getSelectedIndex() == -1) {

					} else {
						Contact c = addressBook.listList.get(lists
								.getSelectedIndex()).contactList
								.get(contactJList.getSelectedIndex());
						infoArea.setText("First Name: " + c.getFirstName()
								+ "\n" + "Last Name: " + c.getLastName() + "\n"
								+ "Nickname: " + c.getNickName() + "\n"
								+ "Birthday: " + c.getBirthday() + "\n"
								+ "Address: " + c.getAddress() + "\n"
								+ "Phone Number: " + c.getPhoneNumber() + "\n"
								+ "Email: " + c.getEmail() + "\n"
								+ "Interests: " + c.getInterest() + "\n"
								+ "Facebook Page: " + c.getFacebookPage());
					}
				}
			}
		} else {

		}
	}

	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"MyAddressBook"));
			AddressBook a = (AddressBook) ois.readObject();
			AddressBookWindow window = new AddressBookWindow(a);
		} catch (Exception e) {
			e.printStackTrace();
			AddressBook a = new AddressBook();
			AddressBookWindow window = new AddressBookWindow(a);
		}
	}

}