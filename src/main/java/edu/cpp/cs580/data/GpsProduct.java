package edu.cpp.cs580.data;

public class GpsProduct {

	private String name;
	private String price;
	private String imgUrl;

	public GpsProduct() {
		super();
	}

	public GpsProduct(String name, String price, String imgUrl) {
		super();
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
