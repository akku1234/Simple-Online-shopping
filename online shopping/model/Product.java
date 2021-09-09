package com.llts.miniproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;



@Entity
public class Product {
	
	@Id
	private int pid;
	private String pname;
	private String pcat;
	private String pdescribe;
	private int pcost;
	private int quantity;

	
	public Product() {
		super();
	}
	public Product(int pid, String pname, String pcat,String pdescribe, int pcost, int quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcat = pcat;
		this.pdescribe = pdescribe;
		this.pcost = pcost;
		this.quantity = quantity;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcat=" + pcat + ", pcost=" + pcost + ", quantity=" + quantity + ", pdescribe=" + pdescribe +"]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	
	private String pimage;
	
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdescribe() {
		return pdescribe;
	}
	public void setPdescribe(String pdescribe) {
		this.pdescribe = pdescribe;
	}


}
