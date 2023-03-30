package org.fi.spring.completerestboot.repositories;

import org.fi.spring.completerestboot.entity.Product;
import org.fi.spring.completerestboot.entity.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,ProductId>
{
	
}
