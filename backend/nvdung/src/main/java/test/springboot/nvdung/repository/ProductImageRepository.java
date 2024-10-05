package test.springboot.nvdung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springboot.nvdung.model.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

}
