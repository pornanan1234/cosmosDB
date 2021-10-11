package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Customer {

	@Id
	public String id;

	public String firstName;
	public String lastName;
    public String phone;

	public Customer() {}

	public Customer(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;

	}

	public void setPhone(String phone) {
		this.phone =phone;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, firstName='%s', lastName='%s' , phone='%s']",
				id, firstName, lastName,phone);
	}

}

