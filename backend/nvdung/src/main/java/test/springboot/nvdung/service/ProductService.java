package test.springboot.nvdung.service;

import org.springframework.http.ResponseEntity;

import test.springboot.nvdung.dto.request.ProductsFilterRequest;
import test.springboot.nvdung.dto.response.ProductDTO;
import test.springboot.nvdung.dto.response.ProductDetailDTO;
import test.springboot.nvdung.dto.response.ResponseModel;

public interface ProductService {
    ResponseModel getAllListProduct(ProductsFilterRequest productsFilterRequest);

    ResponseEntity<ResponseModel> getProductDetail(String id);

    ResponseEntity<ResponseModel> deleteProduct(Integer id);

    ResponseEntity<ResponseModel> createProduct(ProductDTO createProduct);

    ResponseEntity<ResponseModel> updateProduct(Integer id, ProductDTO updateProduct);

    ResponseEntity<ResponseModel> createProductDetail(ProductDetailDTO createProductDetail);

    ResponseEntity<ResponseModel> updateProductDetail(Integer id, ProductDetailDTO updateProductDetail);
}