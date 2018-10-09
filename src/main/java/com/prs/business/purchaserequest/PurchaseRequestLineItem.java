package com.prs.business.purchaserequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.prs.business.product.Product;


@Entity 
public class PurchaseRequestLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int ID;

	@ManyToOne
	@JoinColumn(name="PurchaseRequestID") 
	  private PurchaseRequest purchaseRequest;    

	@ManyToOne
	@JoinColumn(name="ProductID")
	
	  private Product product;      
	  private int Quantity;
	  private int IsActive;
	  private String DateCreated;
	  
	 
	public PurchaseRequestLineItem() {
		super();
	}
	public PurchaseRequestLineItem(int iD, PurchaseRequest purchaseRequest, Product product, int quantity, int isActive,
			String dateCreated) {
		super();
		ID = iD;
		this.purchaseRequest = purchaseRequest;
		this.product = product;
		Quantity = quantity;
		IsActive = isActive;
		DateCreated = dateCreated;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}
	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int isActive) {
		IsActive = isActive;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	
	
	
	@Override
	public String toString() {
		return "PurchaseRequestLineItem [ID=" + ID + ", PurchaseRequest=" + purchaseRequest + ", Product="
				+ product + ", Quantity=" + Quantity + ", IsActive=" + IsActive + ", DateCreated=" + DateCreated
				+ "]";
	}
	  
	  
	  
	
}