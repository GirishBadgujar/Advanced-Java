package org.fi.spring.resthibernateapp1.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.fi.spring.resthibernateapp1.dto.ProductDTO;

import org.fi.spring.resthibernateapp1.entity.Product;
import org.fi.spring.resthibernateapp1.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	@RequestMapping("product")
	public class ProductController
	{
		@Autowired
		ProductRepository repositoryProduct;
		
		@PostMapping("/newProduct")
		
		public Serializable addNew(@RequestBody ProductDTO objProduct)
		
		{
			Product entityProduct = new Product();
			BeanUtils.copyProperties(objProduct, entityProduct);
			return repositoryProduct.save(entityProduct).getProductId();
		}
		@GetMapping("/get/{pid}")
		public ProductDTO
		getProduct(@PathVariable("pid")int ProductId)
		{
			Optional<Product> optProduct = 
					repositoryProduct.findById(ProductId);
			if(optProduct.isPresent())
			{
				Product entityProduct = 
						optProduct.get();
				ProductDTO dto = new ProductDTO();
				BeanUtils.copyProperties(entityProduct, dto);
				return dto;
			}
			return null;
		}
		@GetMapping("/getAll")
		public List<ProductDTO> getProduct()
		{
			Iterator<Product> iter = 
					repositoryProduct.findAll().iterator();
			ArrayList<ProductDTO> list = new
					ArrayList<>();
			while(iter.hasNext())
			{
				Product entityProduct = iter.next();
				ProductDTO dto = new ProductDTO();
				BeanUtils.copyProperties(entityProduct, dto);
				list.add(dto);
			}
			return list;
         }
		
	
	}
