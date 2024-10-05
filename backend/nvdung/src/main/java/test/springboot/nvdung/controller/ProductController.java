package test.springboot.nvdung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import test.springboot.nvdung.dto.request.ProductsFilterRequest;
import test.springboot.nvdung.dto.response.ProductDTO;
import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseModel getListProduct(@RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer sizeId,
            @RequestParam(required = false) Integer styleId,
            @RequestParam(required = false) Integer colorId,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortOrder) {
        ProductsFilterRequest productsFilterRequest = ProductsFilterRequest.builder()
                .categoryId(categoryId)
                .sizeId(sizeId)
                .styleId(styleId)
                .colorId(colorId)
                .maxPrice(maxPrice)
                .minPrice(minPrice)
                .sortBy(sortBy)
                .sortOrder(sortOrder)
                .build();
        return this.productService.getAllListProduct(productsFilterRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> getProductDetail(@PathVariable("id") String id) {
        return this.productService.getProductDetail(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteProduct(@PathVariable("id") Integer id) {
        return this.productService.deleteProduct(id);
    }

    @PostMapping("")
    public ResponseEntity<ResponseModel> createProduct(@RequestBody ProductDTO createProductDTO) {
        return this.productService.createProduct(createProductDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseModel> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO updateProductDTO) {
        return this.productService.updateProduct(id, updateProductDTO);
    }
}
