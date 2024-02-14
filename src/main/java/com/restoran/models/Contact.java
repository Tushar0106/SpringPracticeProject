package com.restoran.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	private int contactId;
	private String contactName;
	private String contactEmail;
	private String contactSubject;
	private String contactMsg;
	private String contactRegDate;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int contactId, String contactName, String contactEmail, String contactSubject, String contactMsg,
			String contactRegDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactSubject = contactSubject;
		this.contactMsg = contactMsg;
		this.contactRegDate = contactRegDate;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactSubject() {
		return contactSubject;
	}
	public void setContactSubject(String contactSubject) {
		this.contactSubject = contactSubject;
	}
	public String getContactMsg() {
		return contactMsg;
	}
	public void setContactMsg(String contactMsg) {
		this.contactMsg = contactMsg;
	}
	public String getContactRegDate() {
		return contactRegDate;
	}
	public void setContactRegDate(String contactRegDate) {
		this.contactRegDate = contactRegDate;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactSubject=" + contactSubject + ", contactMsg=" + contactMsg + ", contactRegDate="
				+ contactRegDate + "]";
	}
	
	
}
