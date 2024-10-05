package test.springboot.nvdung.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.springboot.nvdung.dto.request.ProductsFilterRequest;
import test.springboot.nvdung.dto.response.*;
import test.springboot.nvdung.model.*;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;
import test.springboot.nvdung.repository.*;
import test.springboot.nvdung.repository.specifications.ProductSpecifications;
import test.springboot.nvdung.repository.specifications.ProductSpecificationsRepository;
import test.springboot.nvdung.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductSpecificationsRepository productSpecificationsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ConstantRepository constantRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ResponseModel getAllListProduct(ProductsFilterRequest productsFilterRequest) {
        ResponseModel responseModel = new ResponseModel();

        Specification<Product> spec = Specification
                .where(ProductSpecifications.filterByCategory(productsFilterRequest.getCategoryId()))
                .and(ProductSpecifications.filterBySize(productsFilterRequest.getSizeId()))
                .and(ProductSpecifications.filterByStyle(productsFilterRequest.getStyleId()))
                .and(ProductSpecifications.filterByColor(productsFilterRequest.getColorId()))
                .and(ProductSpecifications.filterByPriceRange(productsFilterRequest.getMinPrice(),
                        productsFilterRequest.getMaxPrice()))
                .and(ProductSpecifications.isNotDeleted());

        String sortBy = productsFilterRequest.getSortBy() != null ? productsFilterRequest.getSortBy() : "price";
        String sortOrder = productsFilterRequest.getSortOrder() != null ? productsFilterRequest.getSortOrder() : "asc";

        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        if (sortOrder.equalsIgnoreCase("desc")) {
            sort = Sort.by(Sort.Direction.DESC, sortBy);
        }

        List<Product> products = productSpecificationsRepository.findAll(spec, sort);

        List<ProductsItemResponse> productRes = products.stream().map((product) -> ProductsItemResponse
                .builder()
                .id(product.getId())
                .rating(product.getRating())
                .name(product.getName())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .salesPrice(product.getSalePrice())
                .productImages(
                        product
                                .getProductImages()
                                .stream()
                                .map((image) -> image.getUrl())
                                .collect(Collectors.toList()))
                .build())
                .collect(Collectors.toList());
        ;

        Map<String, Object> result = new HashMap<>();

        result.put("products", productRes);
        result.put("productCount", productRes.size());

        responseModel.setResult(result);
        responseModel.setMessage("Lấy danh sách sản phẩm thành công");
        return responseModel;
    }

    @Override
    public ResponseEntity<ResponseModel> getProductDetail(String id) {
        ResponseModel responseModel = new ResponseModel();
        Integer intId = 1;

        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            responseModel.setMessage("Id không phải là một số nguyên");
            responseModel.setResult("");
            return ResponseEntity.badRequest().body(responseModel);
        }

        Optional<Product> product = productRepository.findById(intId);

        if (!product.isPresent()) {
            responseModel.setMessage("Không tìm thấy sản phẩm phù hợp");
            responseModel.setResult("");
            return ResponseEntity.notFound().build();
        }

        Product productZ = product.get();

        if (productZ.isDeleted()) {
            responseModel.setMessage("Sản phẩm đã bị xóa");
            responseModel.setResult("");
            return ResponseEntity.notFound().build();
        }

        productZ.setViewedCount(productZ.getViewedCount() + 1);
        productRepository.save(productZ);

        List<ProductDetailDTO> productDetailDTOs = productZ.getProductDetails().stream()
                .map(detail -> ProductDetailDTO.builder()
                        .id(detail.getId())
                        .quantity(detail.getQuantity())
                        .color(detail.getColor().getValue())
                        .size(detail.getSize().getValue())
                        .build())
                .toList();

        responseModel.setResult(ProductDetailResponse
                .builder()
                .id(productZ.getId())
                .price(productZ.getPrice())
                .discount(productZ.getDiscount())
                .salePrice(productZ.getSalePrice())
                .name(productZ.getName())
                .gender(productZ.getGender())
                .description(productZ.getDescription())
                .discountTo(productZ.getDiscountTo())
                .rating(productZ.getRating())
                .ratingCount(productZ.getRatingCount())
                .viewedCount(productZ.getViewedCount())
                .images(productZ.getProductImages().stream().map((image) -> image.getUrl()).toList())
                .style(productZ.getStyle().getValue())
                .category(productZ.getCategory().getValue())
                .productDetails(productDetailDTOs)
                .build());
        responseModel.setMessage("Tìm thấy sản phẩm thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> deleteProduct(Integer id) {
        ResponseModel responseModel = new ResponseModel();

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            responseModel.setMessage("Id sản phẩm nhập vào không thể tìm thấy");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseModel);
        }

        Product product = optionalProduct.get();

        product.setDeleted(true);
        productRepository.save(product);

        List<ProductDetailDTO> productDetailDTOs = product.getProductDetails().stream()
                .map(detail -> ProductDetailDTO.builder()
                        .id(detail.getId())
                        .quantity(detail.getQuantity())
                        .color(detail.getColor().getValue())
                        .size(detail.getSize().getValue())
                        .build())
                .toList();

        responseModel.setResult(ProductDetailResponse
                .builder()
                .id(product.getId())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .salePrice(product.getSalePrice())
                .name(product.getName())
                .gender(product.getGender())
                .description(product.getDescription())
                .discountTo(product.getDiscountTo())
                .rating(product.getRating())
                .ratingCount(product.getRatingCount())
                .viewedCount(product.getViewedCount())
                .images(product.getProductImages().stream().map((image) -> image.getUrl()).toList())
                .style(product.getStyle().getValue())
                .category(product.getCategory().getValue())
                .productDetails(productDetailDTOs)
                .build());
        responseModel.setMessage("Xóa sản phẩm thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> createProduct(ProductDTO createProduct) {
        ResponseModel responseModel = new ResponseModel();

        Optional<Product> product1 = productRepository.findById(1);

        List<ProductImage> productImages = new ArrayList<>();
        // Insert Image
        createProduct.getImages().stream().forEach((imageUrl) -> {
            ProductImage productImage = productImageRepository.save(ProductImage
                    .builder()
                    .url(imageUrl)
                    .product(product1.get())
                    .build());
            productImages.add(productImage);
        });

        // category
        Optional<Constant> optionalCategory = constantRepository.findByTypeAndValue(ConstantTypeEnum.CATEGORY,
                createProduct.getCategory());

        Constant category = new Constant();

        if (!optionalCategory.isPresent()) {
            category = constantRepository.save(Constant
                    .builder()
                    .type(ConstantTypeEnum.CATEGORY)
                    .value(createProduct.getCategory())
                    .build());
        } else {
            category = optionalCategory.get();
        }

        // style
        Optional<Constant> optionalStyle = constantRepository.findByTypeAndValue(ConstantTypeEnum.STYLE,
                createProduct.getStyle());

        Constant style = new Constant();

        if (!optionalStyle.isPresent()) {
            style = constantRepository.save(Constant
                    .builder()
                    .type(ConstantTypeEnum.STYLE)
                    .value(createProduct.getStyle())
                    .build());
        } else {
            style = optionalStyle.get();
        }

        Product newProduct = productRepository.save(Product
                .builder()
                .price(createProduct.getPrice())
                .discount(createProduct.getDiscount())
                .name(createProduct.getName())
                .gender(createProduct.getGender())
                .description(createProduct.getDescription())
                .discountTo(createProduct.getDiscountTo())
                .isDeleted(false)
                .rating(createProduct.getRating())
                .ratingCount(createProduct.getRatingCount())
                .viewedCount(createProduct.getViewedCount())
                .category(category)
                .style(style)
                .productImages(productImages)
                .productDetails(new ArrayList<>())
                .build());

        productImages.stream().forEach((image) -> {
            image.setProduct(newProduct);
            productImageRepository.save(image);
        });

        responseModel.setResult(ProductDetailResponse
                .builder()
                .id(newProduct.getId())
                .price(newProduct.getPrice())
                .discount(newProduct.getDiscount())
                .salePrice(newProduct.getSalePrice())
                .name(newProduct.getName())
                .gender(newProduct.getGender())
                .description(newProduct.getDescription())
                .discountTo(newProduct.getDiscountTo())
                .rating(newProduct.getRating())
                .ratingCount(newProduct.getRatingCount())
                .viewedCount(newProduct.getViewedCount())
                .images(createProduct.getImages())
                .style(createProduct.getStyle())
                .category(createProduct.getCategory())
                .productDetails(new ArrayList<>())
                .build());

        responseModel.setMessage("Thêm sản phẩm thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> updateProduct(Integer id, ProductDTO updateProduct) {
        ResponseModel responseModel = new ResponseModel();

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            responseModel.setMessage("Id sản phẩm nhập vào không thể tìm thấy");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseModel);
        }

        Product product = optionalProduct.get();

        List<ProductImage> productImages;
        if (updateProduct.getImages() != null && !updateProduct.getImages().isEmpty()) {
            List<ProductImage> newProductImages = updateProduct.getImages().stream()
                    .map(imageUrl -> ProductImage.builder()
                            .url(imageUrl)
                            .product(product)
                            .build())
                    .collect(Collectors.toList());
            productImageRepository.saveAll(newProductImages);
            productImages = newProductImages;
        } else {
            productImages = product.getProductImages();
        }

        Constant category = null;
        if (updateProduct.getCategory() != null) {
            category = constantRepository.findByTypeAndValue(ConstantTypeEnum.CATEGORY, updateProduct.getCategory())
                    .orElseGet(() -> constantRepository.save(Constant.builder()
                            .type(ConstantTypeEnum.CATEGORY)
                            .value(updateProduct.getCategory())
                            .build()));
        } else {
            category = product.getCategory();
        }

        Constant style = null;
        if (updateProduct.getStyle() != null) {
            style = constantRepository.findByTypeAndValue(ConstantTypeEnum.STYLE, updateProduct.getStyle())
                    .orElseGet(() -> constantRepository.save(Constant.builder()
                            .type(ConstantTypeEnum.STYLE)
                            .value(updateProduct.getStyle())
                            .build()));
        } else {
            style = product.getStyle();
        }

        product.setPrice(updateProduct.getPrice() != null ? updateProduct.getPrice() : product.getPrice());
        product.setDiscount(updateProduct.getDiscount() != null ? updateProduct.getDiscount() : product.getDiscount());
        product.setName(updateProduct.getName() != null ? updateProduct.getName() : product.getName());
        product.setGender(updateProduct.getGender() != null ? updateProduct.getGender() : product.getGender());
        product.setDescription(
                updateProduct.getDescription() != null ? updateProduct.getDescription() : product.getDescription());
        product.setDiscountTo(
                updateProduct.getDiscountTo() != null ? updateProduct.getDiscountTo() : product.getDiscountTo());
        product.setCategory(category);
        product.setStyle(style);
        product.setProductImages(productImages);

        productRepository.save(product);

        List<String> imageUrls = product.getProductImages().stream().map(ProductImage::getUrl)
                .collect(Collectors.toList());

        List<ProductDetailDTO> productDetailDTOs = product.getProductDetails().stream()
                .map(detail -> ProductDetailDTO.builder()
                        .id(detail.getId())
                        .quantity(detail.getQuantity())
                        .color(detail.getColor().getValue())
                        .size(detail.getSize().getValue())
                        .build())
                .collect(Collectors.toList());

        ProductDetailResponse productDetailResponse = ProductDetailResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .salePrice(updateProduct.getSalePrice())
                .name(product.getName())
                .gender(product.getGender())
                .description(product.getDescription())
                .discountTo(product.getDiscountTo())
                .rating(updateProduct.getRating())
                .ratingCount(updateProduct.getRatingCount())
                .viewedCount(updateProduct.getViewedCount())
                .images(imageUrls)
                .style(style != null ? style.getValue() : null)
                .category(category != null ? category.getValue() : null)
                .productDetails(productDetailDTOs)
                .build();

        responseModel.setResult(productDetailResponse);
        responseModel.setMessage("Chỉnh sửa sản phẩm thành công");

        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> createProductDetail(ProductDetailDTO createProductDetail) {
        ResponseModel responseModel = new ResponseModel();

        if (createProductDetail.getQuantity() == null
                || createProductDetail.getColor() == null || createProductDetail.getSize() == null
                || createProductDetail.getProductId() == null) {
            responseModel.setMessage("Thông tin chi tiết sản phẩm không hợp lệ");
            return ResponseEntity.badRequest().body(responseModel);
        }

        Optional<Product> optionalProduct = productRepository.findById(createProductDetail.getProductId());
        if (!optionalProduct.isPresent()) {
            responseModel.setMessage("Sản phẩm không tồn tại");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseModel);
        }

        Product product = optionalProduct.get();

        // Size
        Constant size = constantRepository.findByTypeAndValue(ConstantTypeEnum.SIZE, createProductDetail.getSize())
                .orElseGet(() -> constantRepository.save(Constant.builder()
                        .type(ConstantTypeEnum.SIZE)
                        .value(createProductDetail.getSize())
                        .build()));

        // Color
        Constant color = constantRepository.findByTypeAndValue(ConstantTypeEnum.COLOR, createProductDetail.getColor())
                .orElseGet(() -> constantRepository.save(Constant.builder()
                        .type(ConstantTypeEnum.COLOR)
                        .value(createProductDetail.getColor())
                        .build()));

        ProductDetail productDetail = ProductDetail
                .builder()
                .quantity(createProductDetail.getQuantity())
                .color(color)
                .size(size)
                .product(product)
                .build();

        // Lưu vào cơ sở dữ liệu
        productDetail = productDetailRepository.save(productDetail);

        responseModel.setMessage("Tạo chi tiết sản phẩm thành công");
        createProductDetail.setId(productDetail.getId());
        responseModel.setResult(createProductDetail);
        return ResponseEntity.ok().body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> updateProductDetail(Integer id, ProductDetailDTO updateProductDetail) {
        ResponseModel responseModel = new ResponseModel();

        if (updateProductDetail == null) {
            responseModel.setMessage("Thông tin chi tiết sản phẩm không hợp lệ");
            return ResponseEntity.badRequest().body(responseModel);
        }

        Optional<ProductDetail> optionalProductDetail = productDetailRepository.findById(id);
        if (!optionalProductDetail.isPresent()) {
            responseModel.setMessage("Chi tiết sản phẩm không tồn tại");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseModel);
        }

        ProductDetail productDetail = optionalProductDetail.get();

        // Size
        Constant size = null;
        if (updateProductDetail.getSize() != null) {
            size = constantRepository.findByTypeAndValue(ConstantTypeEnum.SIZE, updateProductDetail.getSize())
                    .orElseGet(() -> constantRepository.save(Constant.builder()
                            .type(ConstantTypeEnum.SIZE)
                            .value(updateProductDetail.getSize())
                            .build()));
        } else {
            size = productDetail.getSize();
        }

        // Color
        Constant color = null;
        if (updateProductDetail.getColor() != null) {
            color = constantRepository.findByTypeAndValue(ConstantTypeEnum.COLOR, updateProductDetail.getColor())
                    .orElseGet(() -> constantRepository.save(Constant.builder()
                            .type(ConstantTypeEnum.COLOR)
                            .value(updateProductDetail.getColor())
                            .build()));
        } else {
            color = productDetail.getColor();
        }

        productDetail.setQuantity(updateProductDetail.getQuantity() != null ? updateProductDetail.getQuantity()
                : productDetail.getQuantity());
        productDetail.setColor(color);
        productDetail.setSize(size);

        productDetail = productDetailRepository.save(productDetail);

        responseModel.setMessage("Cập nhật chi tiết sản phẩm thành công");
        updateProductDetail.setId(productDetail.getId());
        updateProductDetail.setColor(productDetail.getColor().getValue());
        updateProductDetail.setQuantity(productDetail.getQuantity());
        updateProductDetail.setSize(productDetail.getSize().getValue());
        responseModel.setResult(updateProductDetail);
        return ResponseEntity.ok().body(responseModel);
    }
}