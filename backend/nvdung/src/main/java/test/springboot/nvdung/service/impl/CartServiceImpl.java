package test.springboot.nvdung.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import test.springboot.nvdung.dto.request.CreateCartRequest;
import test.springboot.nvdung.dto.response.CartReponsive;
import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.model.Cart;
import test.springboot.nvdung.model.ProductDetail;
import test.springboot.nvdung.repository.*;
import test.springboot.nvdung.service.CartService;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ResponseEntity<ResponseModel> createCart(CreateCartRequest createCartRequest) {
        ResponseModel responseModel = new ResponseModel();

        Optional<ProductDetail> FoundproductDetail = productDetailRepository
                .findById(createCartRequest.getProductDetailId());

        if (!FoundproductDetail.isPresent()) {
            responseModel.setMessage("Không tìm thấy product detail phù hợp");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseModel);
        }

        if (createCartRequest.getQuantity() <= 0) {
            responseModel.setMessage("Số lượng nhập vào không phù hợp");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseModel);
        }

        Optional<Cart> optionCart = cartRepository.findByProductDetail_Id(createCartRequest.getProductDetailId());

        Cart cart = new Cart();

        if (optionCart.isPresent()) {
            cart = optionCart.get();
            cart.setQuantity(cart.getQuantity() + createCartRequest.getQuantity());
        } else {
            cart = new Cart();
            cart.setProductDetail(FoundproductDetail.get());
            cart.setQuantity(createCartRequest.getQuantity());
        }

        Cart insertedCart = cartRepository.save(cart);

        responseModel.setResult(CartReponsive
                .builder()
                .id(insertedCart.getId())
                .quantity(insertedCart.getQuantity())
                .productDetailId(insertedCart.getProductDetail().getId())
                .createdAt(insertedCart.getCreatedAt())
                .updateAt(insertedCart.getUpdatedAt())
                .build());
        responseModel.setMessage("tạo cart thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseModel getListCart() {
        ResponseModel responseModel = new ResponseModel();

        List<Cart> carts = cartRepository.findAll();

        responseModel.setMessage("Lấy danh sách giỏ hàng thành công");
        responseModel.setResult(carts.stream().map((cart) -> CartReponsive
                .builder()
                .id(cart.getId())
                .quantity(cart.getQuantity())
                .productDetailId(cart.getProductDetail().getId())
                .createdAt(cart.getCreatedAt())
                .updateAt(cart.getUpdatedAt())
                .build()));

        return responseModel;
    }

    @Override
    public ResponseEntity<ResponseModel> updateCart(Integer id, CreateCartRequest updateCart) {
        ResponseModel responseModel = new ResponseModel();

        Optional<Cart> optionalCart = cartRepository.findById(id);

        if (!optionalCart.isPresent()) {
            responseModel.setMessage("Id giỏ hàng nhập vào không phù hợp");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseModel);
        }

        Cart cart = optionalCart.get();

        cart.setQuantity(updateCart.getQuantity());

        cartRepository.save(cart);
        responseModel.setResult(CartReponsive
                .builder()
                .id(cart.getId())
                .quantity(cart.getQuantity())
                .productDetailId(cart.getProductDetail().getId())
                .createdAt(cart.getCreatedAt())
                .updateAt(cart.getUpdatedAt())
                .build());
        responseModel.setMessage("Cập nhập giỏ hàng thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> deleteCart(Integer id){
        ResponseModel responseModel = new ResponseModel();

        Optional<Cart> optionalCart = cartRepository.findById(id);

        if (!optionalCart.isPresent()) {
            responseModel.setMessage("Id giỏ hàng nhập vào không phù hợp");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseModel);
        }

        Cart cart = optionalCart.get();
        
        responseModel.setResult(CartReponsive
                .builder()
                .id(cart.getId())
                .quantity(cart.getQuantity())
                .productDetailId(cart.getProductDetail().getId())
                .createdAt(cart.getCreatedAt())
                .updateAt(cart.getUpdatedAt())
                .build());
        responseModel.setMessage("Xóa giỏ hàng thành công");

        cartRepository.delete(cart);

        return ResponseEntity.ok().body(responseModel);
    }
}
