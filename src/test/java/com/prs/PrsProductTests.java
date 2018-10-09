package com.prs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.prs.business.product.Product;
import com.prs.business.product.ProductRepository;
import com.prs.business.user.User;
import com.prs.business.user.UserRepository;
import com.prs.business.vendor.Vendor;
import com.prs.business.vendor.VendorRepository;

@RunWith(SpringRunner.class)
public class PrsProductTests extends PrswebApplicationTests {
	@Autowired 
	private ProductRepository productRepository;
	@Autowired 
	private VendorRepository vendorRepository;

	@Test
	public void testProductCrudFunctions() {
			
		
		//Get all Products
		Iterable<Product> products = productRepository.findAll();
		assertNotNull(products);
		
		//Add a Product
		Optional <Vendor> v = vendorRepository.findById(3);
		Product p1 = new Product(v.get(), "partnumber", "name", 100.00, "unit", "photopath");
		assertNotNull(productRepository.save(p1));
		int id = p1.getID();
		
		//Get user & validate name is correct
		Optional<Product> u2 = productRepository.findById(id);
		assertEquals(u2.get().getName(),"name");
		
		//Update the Product
		u2.get().setName("newName");
		assertNotNull(productRepository.save(u2.get()));
		
		//Remove the Product
		productRepository.delete(u2.get());
		assertThat(!(productRepository.findById(id)).isPresent());
		
		}
}
