package model.user;

import java.util.Date;

import utils.ViewSet;

public class RentRecord {

private int id;//����ID
private int carid;//����ID
private int userid;//�û�id
private  String Username;//�û���
private String model;//�����ͺ�
private double rent;//���޼۸�
private double payment;//֧������
private String tcomments;//������ע
private String  brand;//����Ʒ��
private String category;//��������
private Date startdate;//�⳵ʱ��
private Date returndate;//����ʱ��





@Override
public String toString() {
	return   id+"\t"+carid + "\t" + userid + "\t" + Username + "\t"
			+ model + "\t" + rent + "\t" + payment + "\t" + tcomments + "\t\t" + brand
			+ "\t" + category + "\t" + startdate + "\t" +ViewSet.tocase(returndate) ;
}
public RentRecord(int id, int carid, int userid, String username, String model, double rent, double payment,
		String tcomments, String brand, String category, Date startdate, Date returndate) {
	super();
	this.id = id;
	this.carid = carid;
	this.userid = userid;
	Username = username;
	this.model = model;
	this.rent = rent;
	this.payment = payment;
	this.tcomments = tcomments;
	this.brand = brand;
	this.category = category;
	this.startdate = startdate;
	this.returndate = returndate;
}
public RentRecord() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCarid() {
	return carid;
}
public void setCarid(int carid) {
	this.carid = carid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public double getRent() {
	return rent;
}
public void setRent(double rent) {
	this.rent = rent;
}
public double getPayment() {
	return payment;
}
public void setPayment(double payment) {
	this.payment = payment;
}
public String getTcomments() {
	return tcomments;
}
public void setTcomments(String tcomments) {
	this.tcomments = tcomments;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public Date getReturndate() {
	return returndate;
}
public void setReturndate(Date returndate) {
	this.returndate = returndate;
}

}
