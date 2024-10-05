package test.springboot.nvdung.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import test.springboot.nvdung.model.*;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByProductDetail_Id(Integer productDetailId);
}
