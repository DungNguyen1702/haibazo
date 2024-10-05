package test.springboot.nvdung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import test.springboot.nvdung.dto.response.ProductDetailDTO;
import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.service.ProductService;

@RestController
@RequestMapping("/product-details")
public class ProductDetailController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<ResponseModel> createProductDetaEntity(@RequestBody ProductDetailDTO createProductDetailDTO) {
        return this.productService.createProductDetail(createProductDetailDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel> updateProductDetaEntity(@PathVariable("id") Integer id, @RequestBody ProductDetailDTO updateProductDTO) {
        return this.productService.updateProductDetail(id, updateProductDTO);
    }
}
