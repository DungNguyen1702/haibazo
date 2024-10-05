package test.springboot.nvdung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.springboot.nvdung.dto.request.CreateCartRequest;
import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    public ResponseEntity<ResponseModel> createCart(@RequestBody CreateCartRequest createCartRequest) {
        return this.cartService.createCart(createCartRequest);
    }

    @GetMapping()
    public ResponseModel getListCart() {
        return this.cartService.getListCart();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel> updateCart(@PathVariable Integer id, @RequestBody CreateCartRequest updateCartRequest) { 
        return this.cartService.updateCart(id, updateCartRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteCart(@PathVariable Integer id) { 
        return this.cartService.deleteCart(id);
    }
    
}
