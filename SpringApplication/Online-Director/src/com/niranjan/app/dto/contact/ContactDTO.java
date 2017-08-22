package com.niranjan.app.dto.contact;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.niranjan.app.dto.register.RegisterDTO;

@Entity
@Table(name="contact")
public class ContactDTO implements Serializable{
	@GenericGenerator(name="pk",strategy="increment")
	@GeneratedValue(generator="pk")
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="number")
	private int number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="operator")
	private String operator;
	
	@Column(name="state")
	private String state;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private RegisterDTO registerDTO;
	
	public ContactDTO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public RegisterDTO getRegisterDTO() {
		return registerDTO;
	}


	public void setRegisterDTO(RegisterDTO registerDTO) {
		this.registerDTO = registerDTO;
	}


	@Override
	public String toString() {
		return "ContactDTO [id=" + id + ", name=" + name + ", address=" + address + ", operator=" + operator + ", state="
				+ state + "]";
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
}
