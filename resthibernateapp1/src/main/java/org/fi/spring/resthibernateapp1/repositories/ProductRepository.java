package org.fi.spring.resthibernateapp1.repositories;

import org.fi.spring.resthibernateapp1.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> 
{

}


