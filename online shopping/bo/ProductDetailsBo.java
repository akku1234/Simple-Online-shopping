package com.llts.miniproject.bo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.llts.miniproject.model.Product;

@Repository
public interface ProductDetailsBo extends JpaRepository<Product, Integer>{
	
}

