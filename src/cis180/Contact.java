package cis180;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Contact extends ContactEditor {
	private String firstname = "";
	private String lastname = "";
	private String email = "";
	private String phone = "";
	private String birthday = "";
	private String age = "";
	private boolean sex;
	private String hobbies = "";
	private String facebook = "";
	
	
	
	private String adress = ""; 
	
	public Contact(){
		
	}
	public Contact(String f, String l, String e, String p, String b, String a, String h, String face ){
		firstname = f;
		lastname = l;
		email = e;
		phone = p;
		birthday = b;
		age = a;
		hobbies = h;
		facebook = face;
		
		
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void print() {
		System.out.print(firstname + ", " + lastname + ", " + email + ", " + phone + ", " + birthday + ", " + hobbies + ", " + facebook );
		
	}
	public static void main(String[]args){
		//Contact one = new Contact("f" ,"f","","","","","","");
	//	one.print();
	}
	
	
}

