package com.model;

public class Item {
	private String itemId;
	private String price;
	private String title;
	private String sales;
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String type5;
	private String img;
	private String url;
	public String getType5() {
		return type5;
	}
	public void setType5(String type5) {
		this.type5 = type5;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString(){
		return "item " + itemId +
				", title is " + title +
				", sales is " + sales +
				", price is " + price +
				", type1 is " + type1 +
				", type2 is " + type2+
				", type3 is " + type3 +
				", type4 is " + type4 +
				", type5 is " + type5 +
				", url is " + url +
				", img is " + img;
		
	}
}
