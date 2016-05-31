package model;
//数据的载体,,,,简单的数据类、po类、伪类、主要方便于持久层转化
public class Guitar {
	
	//所有的吉他属性
	private String serialNumber;
	private Double price;
	private String builder;
	private String type;
	private String backwood;
	private String topwood;

	//set、get方法
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackwood() {
		return backwood;
	}
	public void setBackwood(String backwood) {
		this.backwood = backwood;
	}
	public String getTopwood() {
		return topwood;
	}
	public void setTopwood(String topwood) {
		this.topwood = topwood;
	}




}
