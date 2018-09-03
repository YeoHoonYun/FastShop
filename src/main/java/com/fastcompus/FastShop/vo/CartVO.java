package com.fastcompus.FastShop.vo;

public class CartVO {
	private String name;
	private int price;
	private int dize;
	private String color;
	private int amount;
	private String imgUrl;
	private String cartDate;
	private int usersId;
	private int productsId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDize() {
		return dize;
	}
	public void setDize(int dize) {
		this.dize = dize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCartDate() {
		return cartDate;
	}
	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public int getProductsId() {
		return productsId;
	}
	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}
}
