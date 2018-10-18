package com.ahextech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="registration")
public class RegistrationEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
     private int id;	
	 @NotNull(message="UserName should not be empty")
     @Size(min=4, message="Name should have atleast 4 characters")
     @NotEmpty(message="Name should not be empty")
     @Column(name="username")
     private String username;
	
     @NotNull(message="Email should not be empty")
	 @Email(message="Please provide a valid email address")
     @Column
	 private String email;
	 
	 @NotNull(message="Password should not be empty")
     @Size(min=6, message="Password should have atleast 6 characters")
	 @Column
	 private String password;

	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}
*/
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	
	
}