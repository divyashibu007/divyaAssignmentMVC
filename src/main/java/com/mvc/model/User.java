package com.mvc.model;

import javax.persistence.*;
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "users")
public class User  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(name = "user_name", nullable = false, length = 20)
	private String userName;
	
	@Column(name = "mobile_no", nullable = false, length = 20)
	private String mobileNo;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String email, String password, String userName, String mobileNo) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.mobileNo = mobileNo;
	}

 //getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() { return userName; }

	public void setUserName(String userName) { this.userName = userName; }

	public String getMobileNo() { return mobileNo; }

	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }





@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", mobileNo='" + mobileNo + '\'' +
				'}';
	}
}
