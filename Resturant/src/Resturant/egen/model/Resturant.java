package Resturant.egen.model;

import java.sql.Timestamp;

public class Resturant {

	private int CON_id;
	private String firstName;
	private String lastName;
	private String email;
	private Timestamp date;
	private String phone;
	
	public int getCON_id() {
		return CON_id;
	}
	public void setCON_id(int cON_id) {
		CON_id = cON_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	
	
}
