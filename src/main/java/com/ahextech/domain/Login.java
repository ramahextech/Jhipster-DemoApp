package com.ahextech.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="login")
public class Login {
	     @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
	     @JsonIgnore
	     private int id;	
		
	     @NotEmpty(message="Email should not be empty")
	     @Column(unique = true)
	     @Email(message="Please provide a valid email address")
		 private String email;
	     
	   /*  @NotEmpty(message="Name should not be empty")
	     @Column(name="name",unique = true)
	     private String username;*/
	     
	     @NotEmpty(message="Password should not be empty")
		 @Column(name="password",unique=true)
		 private String password;
	    
	     @JsonIgnore
	     @Column
	     private String uuid;
	     
	     @JsonIgnore
	     @Column
	     private int expirydays;
	     
	     @JsonIgnore
	     @Column(name="login_date")
	     private Date date;

	    /* @JsonIgnore
	     @ManyToMany
	     @JoinTable(
	         name = "login_authority",
	         joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	         inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
	      @BatchSize(size = 20)
	     private Set<LoginAuthority> loginAuthorities = new HashSet<>();*/
		public int getId() {
			return id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public int getExpirydays() {
			return expirydays;
		}

		public void setExpirydays(int expirydays) {
			this.expirydays = expirydays;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public void setId(int id) {
			this.id = id;
		}

		/*public Set<LoginAuthority> getAuthorities() {
			return loginAuthorities;
		}

		public void setAuthorities(Set<LoginAuthority> authorities) {
			this.loginAuthorities = authorities;
		}*/
		
		
}
