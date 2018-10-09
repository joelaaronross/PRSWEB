package com.prs.business.purchaserequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.prs.business.user.User;



@Entity
public class PurchaseRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	  private  User user;
	  private String Description;     
	  private String Justification;
	  private String DateNeeded;
	  private String DeliveryMode;
	  private String Status;
	  private double Total;
	  private String SubmittedDate;
	
	  public PurchaseRequest() {
			super();
		}
	  
	  
	public PurchaseRequest(int iD, User user, String description, String justification, String dateNeeded,
			String deliveryMode, String status, double total, String submittedDate) {
		super();
		ID = iD;
		this.user = user;
		Description = description;
		Justification = justification;
		DateNeeded = dateNeeded;
		DeliveryMode = deliveryMode;
		Status = status;
		Total = total;
		SubmittedDate = submittedDate;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getJustification() {
		return Justification;
	}
	public void setJustification(String justification) {
		Justification = justification;
	}
	public String getDateNeeded() {
		return DateNeeded;
	}
	public void setDateNeeded(String dateNeeded) {
		DateNeeded = dateNeeded;
	}
	public String getDeliveryMode() {
		return DeliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		DeliveryMode = deliveryMode;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public String getSubmittedDate() {
		return SubmittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		SubmittedDate = submittedDate;
	}
	
	@Override
	public String toString() {
		return "PurchaseRequest [ID=" + ID + ", user=" + user + ", Description=" + Description + ", Justification="
				+ Justification + ", DateNeeded=" + DateNeeded + ", DeliveryMode=" + DeliveryMode + ", Status=" + Status
				+ ", Total=" + Total + ", SubmittedDate=" + SubmittedDate + "]";
	}	
	  
	  
	  
	  
	  
}