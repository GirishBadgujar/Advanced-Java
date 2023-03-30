package org.fi.spring.resthibernateapp1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_0058")
public class Product 
{
	@Id
	@GeneratedValue(generator="increment")
	
	@Column(name="categoryid")
	int categoryId;
	
	@Column(name="productid")
	int productId;
	
	@Column(name="productname")
	String productName;
	
	@Column(name="productdescription")
	String productDescription;
	
	@Column(name="productimageurl")
	String productImageUrl;
	
	@Column(name="productprice")
	float productPrice;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
