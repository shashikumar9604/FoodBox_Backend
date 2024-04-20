package com.foodbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("Select p FROM Product p WHERE p.avail='yes' ORDER BY 'category'")
	List<Product> findIfAvail();
	
	@Query("SELECT p FROM Product p WHERE (p.avail LIKE 'yes') AND (p.name LIKE %?1%"
			+" OR p.des LIKE %?1%"
			+" OR p.price LIKE %?1%"
			+" OR p.category LIKE %?1%)")
	public List<Product> homeSearch(String keyword);
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Veg' AND p.avail LIKE 'yes'")
	public List<Product> getVeg();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'NonVeg' AND p.avail LIKE 'yes'")
	public List<Product> getNonVeg();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Pizza' AND p.avail LIKE 'yes'")
	public List<Product> getPizza();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Burger' AND p.avail LIKE 'yes'")
	public List<Product> getBurger();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Rolls' AND p.avail LIKE 'yes'")
	public List<Product> getRolls();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Momos' AND p.avail LIKE 'yes'")
	public List<Product> getMomos();
	
	@Query("SELECT p FROM Product p WHERE p.category LIKE 'Juice' AND p.avail LIKE 'yes'")
	public List<Product> getjuice();
}
