package test.springboot.nvdung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springboot.nvdung.model.*;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}
