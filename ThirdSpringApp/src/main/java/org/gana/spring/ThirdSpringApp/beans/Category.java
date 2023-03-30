package org.gana.spring.ThirdSpringApp.beans;

import org.springframework.stereotype.Component;

@Component
public class Category 
{
	int categoryId;
	String categoryName;
	
	public Category() 
	{
		System.out.println("Category constructor Fired.");
	}
	
	public int getCategoryId()
	{
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	
	public String getCategoryName(String categoryName) 
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
}
