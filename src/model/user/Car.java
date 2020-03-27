package model.user;

import utils.ViewSet;

/**
 * @author WXZ
 *汽车类
 */
public class Car {
	private Integer id;             //car id
	private String carnumber;   //car车牌编号
	private String brand;       //car品牌
	private Integer brandid;////car品牌编号
	private String color;       //car颜色
	private String category;    //car 类别
	private Integer categoryid;    //car 类别编号
	private String comments;    //备注信息：car排量
	private Double price;       //car价格
	private Double rent;           //car租赁价格
	private Integer status;         //租车状态
	private Integer useable;        //是否可用
	private String model;//名称
	
	@Override
	public String toString() {
		
		return id + "\t" + carnumber + "\t" + brand +  "\t"
				+ color + "\t" + category +  "\t" + comments
				+ "\t\t" + price + "\t" + rent + "\t" 
				+ ViewSet.tocase(status) + "\t" 
				+ ViewSet.tocase(useable) + "\t"
				+ model;
	}

	public Car() {
		
	}

	public Car(Integer id, String carnumber, String brand, Integer brandid, String color, String category,
			Integer categoryid, String comments, Double price, Double rent, Integer status, Integer useable,
			String model) {
		super();
		this.id = id;
		this.carnumber = carnumber;
		this.brand = brand;
		this.brandid = brandid;
		this.color = color;
		this.category = category;
		this.categoryid = categoryid;
		this.comments = comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.model = model;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUseable() {
		return useable;
	}

	public void setUseable(Integer useable) {
		this.useable = useable;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	

}
