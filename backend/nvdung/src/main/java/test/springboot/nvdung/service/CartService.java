package test.springboot.nvdung.service;

import org.springframework.http.ResponseEntity;

import test.springboot.nvdung.dto.request.CreateCartRequest;
import test.springboot.nvdung.dto.response.ResponseModel;

public interface CartService {
    ResponseEntity<ResponseModel> createCart(CreateCartRequest createCartRequest);

    ResponseModel getListCart();
    
    ResponseEntity<ResponseModel> updateCart(Integer id, CreateCartRequest updateCart);

    ResponseEntity<ResponseModel> deleteCart(Integer id);

    
}