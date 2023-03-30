package org.fi.spring.resthibernateapp1.repositories;

import org.fi.spring.resthibernateapp1.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> 
{

}
