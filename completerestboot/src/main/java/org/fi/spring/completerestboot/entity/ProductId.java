package org.fi.spring.completerestboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductId implements Serializable
{
	private static final long serialVersionUID = 5919782434124655418L;
	
	@Column(name="categoryid")
	int categoryid;
	
	@Column(name="productid")
	int productId;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
