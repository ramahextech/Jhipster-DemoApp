package com.ahextech.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="profile")
public class UserProfile {
	@NotNull(groups = New.class)
	@JsonIgnore
	@Id
	private int id;

	
	@NotNull(groups = New.class)
	 @Size(min=4,max=10,groups = {Existing.class, New.class})
	@Column
    private String firstname;
	@NotNull(groups = New.class)
	 @Size(min=4,max=10,groups = {Existing.class, New.class})
	@Column
	private String lastname;
	
	@NotNull(groups = New.class)
	@Size(min=4,max=10,groups = {Existing.class, New.class})
	@Column
	private String address;
	 @Size(min=4,max=10,groups = {Existing.class, New.class})
	@NotNull(groups = New.class)
	@Column
	private String city;
	 @Size(min=4,max=10,groups = {Existing.class, New.class})
	@NotNull(groups = New.class)
	@Column
	private String country;
	
	 @Size(min=10,max=10,groups = {Existing.class, New.class})
	 @NotNull(groups = New.class)
	 @Pattern(regexp="(^$|[0,1-9]{10})",groups = {Existing.class, New.class})
    @Column
    private  String mobnumber;
	 
	  
        @JsonIgnore
		@Column(name="profile_photo")
		@Lob
		private String encodedImageFile;
    
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
/*	public long getNumber() {
		return mobnumber;
	}
	public void setNumber(long number) {
		this.mobnumber = number;
	}
*/	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobnumber() {
		return mobnumber;
	}
	public void setMobnumber(String mobnumber) {
		this.mobnumber = mobnumber;
	}
	
	/*public MultipartFile getMultipartFile() {
		return MultipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		MultipartFile = multipartFile;
	}*/


	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", mobnumber=" + mobnumber + "]";
	}
   
	

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobnumber == null) ? 0 : mobnumber.hashCode());
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (address == null) {
			if (other.address != null)
				return false;
			
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobnumber == null) {
			if (other.mobnumber != null)
				return false;
		} else if (!mobnumber.equals(other.mobnumber))
			return false;
		return true;
	}
  
	public UserProfile(@NotNull int id, @NotNull @Size(min = 4, max = 10) String firstname,
			@NotNull @Size(min = 4, max = 10) String lastname, @Size(min = 4, max = 10) @NotNull String address,
			@Size(min = 4, max = 10) @NotNull String city, @Size(min = 4, max = 10) @NotNull String country,
			@Digits(integer=10,fraction=0)  String mobnumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.mobnumber = mobnumber;
	}
	
	public UserProfile(UserProfile readprofile) {
		UserProfile userprofile=readprofile;
	}
	
	public UserProfile() {
		super();
	}
	 public interface Existing {
	    }
	 
	    public interface New {
	    }

		public String getEncodedImageFile() {
			return encodedImageFile;
		}
		public void setEncodedImageFile(String encodedImageFile) {
			this.encodedImageFile = encodedImageFile;
		}

		/*public Byte[] getImage() {
			return image;
		}
		public void setImage(Byte[] image) {
			this.image = image;
		}
*/
		
		
}
