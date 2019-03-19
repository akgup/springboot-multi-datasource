package com.buzzybrains.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buzzybrains.entity.product.Product;

/**
* akshay gupta

* 19-Mar-2019

**/

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}


