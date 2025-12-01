import java.io.Serializable;

import javax.swing.*;

public class Contact implements Serializable {

	// Field Definitions
	private String firstName;
	private String lastName;
	private String nickName;
	private String birthday;
	private String address;
	private String phoneNumber;
	private String email;
	private String interest;
	private String facebookPage;

	// Default Constructor
	public Contact() {

	}

	// Constructor
	public Contact(String f, String l, String n, String bd, String a, String p,
			String e, String i, String fb) {
		firstName = f;
		lastName = l;
		nickName = n;
		birthday = bd;
		address = a;
		phoneNumber = p;
		email = e;
		interest = i;
		facebookPage = fb;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * @param interest
	 *            the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * @return the facebookPage
	 */
	public String getFacebookPage() {
		return facebookPage;
	}

	/**
	 * @param facebookPage
	 *            the facebookPage to set
	 */
	public void setFacebookPage(String facebookPage) {
		this.facebookPage = facebookPage;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}