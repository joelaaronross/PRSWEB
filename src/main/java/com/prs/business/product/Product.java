package com.prs.business.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.prs.business.vendor.Vendor;


		@Entity
public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	

		  private int ID;
		@ManyToOne
		@JoinColumn(name="vendorID")
		  private Vendor vendor;
		  private String PartNumber;     
		  private String Name;
		  private double Price;
		  private String Unit;
		  private String photoPath;

		  public Product() {
			  super();
		  }
		  
		public Product(int iD, Vendor vendor, String partNumber, String name, double price, String unit, String photoPath) {
			super();
			
			this.ID = iD;
			this.vendor = vendor;
			this.PartNumber = partNumber;
			this.Name = name;
			this.Price = price;
			this.Unit = unit;
			this.photoPath = photoPath;
		}
		
		public Product(Vendor vendor, String partNumber, String name, double price, String unit, String photoPath) {
			super();
			this.vendor = vendor;
			PartNumber = partNumber;
			Name = name;
			Price = price;
			Unit = unit;
			this.photoPath = photoPath;
		}

		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public Vendor getVendor() {
			return vendor;
		}
		public void setVendor(Vendor vendor) {
			this.vendor = vendor;
		}
		public String getPartNumber() {
			return PartNumber;
		}
		public void setPartNumber(String partNumber) {
			PartNumber = partNumber;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public String getUnit() {
			return Unit;
		}
		public void setUnit(String unit) {
			Unit = unit;
		}
		public String getPhotoPath() {
			return photoPath;
		}
		public void setPhotoPath(String photoPath) {
			this.photoPath = photoPath;
		}

		@Override
		public String toString() {
			return "Product [ID=" + ID + ", Vendor=" + vendor + ", PartNumber=" + PartNumber + ", Name=" + Name
					+ ", Price=" + Price + ", Unit=" + Unit + ", photPath=" + photoPath + "]";
		}
		 
		  
		  
		  
	

	}


