package com.buzzybrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.buzzybrains.dao.product.ProductRepository;
import com.buzzybrains.dao.user.UserRepository;
import com.buzzybrains.entity.product.Product;
import com.buzzybrains.entity.user.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MultipleDataSourceApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testUserCreate() {
		userRepository.save(new User("akshay", "arindam4@buzzybrains.com", 29));
	}

	@Test
	public void testProductCreate() {
		productRepository.save(new Product(1,"iPhone7", 48000));

	}

}
