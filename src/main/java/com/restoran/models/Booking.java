package com.restoran.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	private int requestId;
	
	private String clientName;
	
	private String email;
	
	private String dateAndTime;
	
	private String people;
	
	private String specialRequest;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int requestId, String clientName, String email, String dateAndTime, String people,
			String specialRequest) {
		super();
		this.requestId = requestId;
		this.clientName = clientName;
		this.email = email;
		this.dateAndTime = dateAndTime;
		this.people = people;
		this.specialRequest = specialRequest;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	@Override
	public String toString() {
		return "Booking [requestId=" + requestId + ", clientName=" + clientName + ", email=" + email + ", dateAndTime="
				+ dateAndTime + ", people=" + people + ", specialRequest=" + specialRequest + "]";
	}
	
}
