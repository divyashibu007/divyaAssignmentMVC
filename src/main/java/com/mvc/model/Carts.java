package com.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;



@Entity
public class Carts {

	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private String status;

	//generated getter setter method
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Column(unique = true)
	private List<Product> productList;



	@Column(unique = false)
	@ManyToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Column(unique = true)
	private List<User> userList;

	@Column(unique = false)
	@ManyToMany(targetEntity = User.class,cascade = CascadeType.ALL)
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList)

	{ this.userList = userList; }





}


	    
	  


