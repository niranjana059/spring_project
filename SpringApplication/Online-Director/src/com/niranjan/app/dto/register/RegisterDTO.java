package com.niranjan.app.dto.register;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.niranjan.app.dto.contact.ContactDTO;

@Entity
@Table(name="RegisterUser")
public class RegisterDTO implements Serializable{
	@Id
	@GenericGenerator(name="idGenerator",strategy="increment")
	@GeneratedValue(generator="idGenerator") // @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="user_name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="confirm_password")
	private String confirmPassword;
	@Column(name="phone_number")	
	private long phoneNumber;
	@Column(name="country")
	private String country;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="registerDTO")
	private Collection<ContactDTO> contactDTO;
	
	@Column(name="status")
	private boolean status;
	
	public RegisterDTO(){
		System.out.println(this.getClass().getSimpleName()+" created ...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<ContactDTO> getContactDTO() {
		return contactDTO;
	}

	public void setContactDTO(Collection<ContactDTO> contactDTO) {
		this.contactDTO = contactDTO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
