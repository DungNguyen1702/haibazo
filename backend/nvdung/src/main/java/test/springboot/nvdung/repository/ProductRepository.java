package test.springboot.nvdung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springboot.nvdung.model.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
