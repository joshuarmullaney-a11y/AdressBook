package cis180;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ContactEditor extends JFrame implements ActionListener {
 
	private Contact contact;
	private JTextField first = new JTextField("First Name");
	private JTextField last = new JTextField("Last Name");
	private JTextField email = new JTextField("Email");
	private JTextField phone = new JTextField("Phone Number");
	private JTextArea address = new JTextArea("City,                  State,                   Street,                Zip Code,             Country");
	private JTextField face = new JTextField("Facebook Page");
	private JTextField birthday = new JTextField("Birthday DD/MM/YYYY");
	private JTextArea hobby = new JTextArea("Write their hobbies and interests here.");
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");
	

	public ContactEditor(Contact c){
		contact = c;
		
		this.setLayout(new BorderLayout());
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(8,2));
		JLabel firstn = new JLabel("First Name:");
		container.add(firstn);
		container.add(first);
		JLabel lastn = new JLabel("Last Name:");
		container.add(lastn);
		container.add(last);
		JLabel email1 = new JLabel("Email Address:");
		container.add(email1);
		container.add(email);
		JLabel phone1 = new JLabel("Phone Number:");
		container.add(phone1);
		container.add(phone);
		JLabel address1 = new JLabel("Address:");
		container.add(address1);
		container.add(address);
		address.setLineWrap(true);
		JLabel facebook = new JLabel("Facebook Page:");
		container.add(facebook);
		container.add(face);
		JLabel birthday1 = new JLabel("Birthday:");
		container.add(birthday1);
		container.add(birthday);
		JLabel hobbies = new JLabel("Hobbies/Interests:");
		container.add(hobbies);
		container.add(hobby);
		this.add(container, BorderLayout.CENTER);
		JPanel savecancel = new JPanel();
		savecancel.add(save);
		save.addActionListener(this);
		save.addActionListener(contact);
		savecancel.add(cancel);
		cancel.addActionListener(this);
		this.add(savecancel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	public ContactEditor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Contact one = new Contact();
		new ContactEditor(one);
		

	}
	public void saving(String f, String l, String e, String p, String b, String a, String h, String face){
		contact.setFirstname(f);
		contact.setLastname(l);
		contact.setEmail(e);
		contact.setPhone(p);
		contact.setBirthday(b);
		contact.setAdress(a);
		contact.setHobbies(h);
		contact.setFacebook(face);
		contact.print();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == save){
			this.saving(first.getText(), last.getText(), email.getText(), phone.getText(), birthday.getText(), address.getText(), hobby.getText(), face.getText());
		
		}
		
	}

}
