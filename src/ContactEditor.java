import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ContactEditor extends JFrame implements ActionListener {

	private Contact contact;

	AddressBook addressBook;

	JButton saveButton = new JButton("Save");
	JButton cancelButton = new JButton("Cancel");
	JMenuItem close = new JMenuItem("Close");

	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JTextField nickNameField = new JTextField();
	JTextField birthdayField = new JTextField();
	JTextArea addressField = new JTextArea();
	JTextField phoneNumberField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField interestField = new JTextField();
	JTextField facebookField = new JTextField();
	JCheckBox friendsBox = new JCheckBox("Friends");
	JCheckBox familyBox = new JCheckBox("Family");
	JCheckBox workBox = new JCheckBox("Work");

	public ContactEditor(AddressBook a) {

		addressBook = a;

		contact = new Contact();

		this.setSize(450, 375);
		this.setTitle("New Contact");
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		close.addActionListener(this);
		file.add(close);
		menubar.add(file);
		this.setJMenuBar(menubar);

		this.setLayout(new GridLayout(11, 2));

		this.add(new JLabel("First Name: "));
		this.add(firstNameField);

		this.add(new JLabel("Last Name: "));
		this.add(lastNameField);

		this.add(new JLabel("Nickname: "));
		this.add(nickNameField);

		this.add(new JLabel("Birthday: "));
		this.add(birthdayField);

		this.add(new JLabel("Address: "));
		JScrollPane addressPane = new JScrollPane(addressField);
		this.add(addressPane);

		this.add(new JLabel("Phone Number: "));
		this.add(phoneNumberField);

		this.add(new JLabel("EMail: "));
		this.add(emailField);

		this.add(new JLabel("Interests: "));
		this.add(interestField);

		this.add(new JLabel("FB Page: "));
		this.add(facebookField);

		this.add(new JLabel("Contact List: "));
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.add(friendsBox);
		checkBoxPanel.add(familyBox);
		checkBoxPanel.add(workBox);
		this.add(checkBoxPanel);

		saveButton.addActionListener(this);
		this.add(saveButton);
		cancelButton.addActionListener(this);
		this.add(cancelButton);

		this.setVisible(true);

	}

	public ContactEditor(AddressBook a, Contact c) {

		addressBook = a;

		contact = c;

		this.setSize(450, 375);
		this.setTitle("Edit Contact");
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem close = new JMenuItem("Close");
		file.add(save);
		file.add(close);
		menubar.add(file);
		JMenu edit = new JMenu("Edit");
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		menubar.add(edit);
		this.setJMenuBar(menubar);

		this.setLayout(new GridLayout(11, 2));

		this.add(new JLabel("First Name: "));
		firstNameField.setText(contact.getFirstName());
		this.add(firstNameField);

		this.add(new JLabel("Last Name: "));
		lastNameField.setText(contact.getLastName());
		this.add(lastNameField);

		this.add(new JLabel("Nickname: "));
		nickNameField.setText(contact.getNickName());
		this.add(nickNameField);

		this.add(new JLabel("Birthday: "));
		birthdayField.setText(contact.getBirthday());
		this.add(birthdayField);

		this.add(new JLabel("Address: "));
		addressField.setText(contact.getAddress());
		this.add(addressField);

		this.add(new JLabel("Phone Number: "));
		phoneNumberField.setText(contact.getPhoneNumber());
		this.add(phoneNumberField);

		this.add(new JLabel("EMail: "));
		emailField.setText(contact.getEmail());
		this.add(emailField);

		this.add(new JLabel("Interests: "));
		interestField.setText(contact.getInterest());
		this.add(interestField);

		this.add(new JLabel("FB Page: "));
		facebookField.setText(contact.getFacebookPage());
		this.add(facebookField);

		this.add(new JLabel("Contact List: "));
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.add(friendsBox);
		checkBoxPanel.add(familyBox);
		checkBoxPanel.add(workBox);
		this.add(checkBoxPanel);

		saveButton.addActionListener(this);
		this.add(saveButton);
		cancelButton.addActionListener(this);
		this.add(cancelButton);

		this.setVisible(true);

	}

	public void save(String f, String l, String n, String bd, String a,
			String p, String e, String i, String b) {

		if (addressBook.listList.get(0).contactList.contains(contact)) {
			addressBook.listList.get(0).contactList.remove(contact);
			addressBook.listList.get(1).contactList.remove(contact);
			addressBook.listList.get(2).contactList.remove(contact);
			addressBook.listList.get(3).contactList.remove(contact);
		}

		contact.setFirstName(f);
		contact.setLastName(l);
		contact.setNickName(n);
		contact.setBirthday(bd);
		contact.setAddress(a);
		contact.setPhoneNumber(p);
		contact.setEmail(e);
		contact.setInterest(i);
		contact.setFacebookPage(b);

		addressBook.listList.get(0).contactList.add(contact);

		if (friendsBox.isSelected()) {
			addressBook.listList.get(1).contactList.add(contact);
		}

		if (familyBox.isSelected()) {
			addressBook.listList.get(2).contactList.add(contact);
		}

		if (workBox.isSelected()) {
			addressBook.listList.get(3).contactList.add(contact);
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == saveButton) {
			this.save(firstNameField.getText(), lastNameField.getText(),
					nickNameField.getText(), birthdayField.getText(),
					addressField.getText(), phoneNumberField.getText(),
					emailField.getText(), interestField.getText(),
					facebookField.getText());
			this.dispose();

		} else {
			this.dispose();
		}
	}

}
