package test.springboot.nvdung.dto.response;

import java.time.LocalDate;
import java.util.*;

import lombok.*;
import test.springboot.nvdung.model.Enum.ProductGender;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private Integer id;
    private Integer price;
    private Integer discount;
    private Integer salePrice;
    private String name;
    private ProductGender gender;
    private String description;
    private LocalDate discountTo;
    private double rating;
    private Integer ratingCount;
    private Integer viewedCount;
    private List<String> images;
    private String style;
    private String category;
    private List<ProductDetailDTO> productDetails;
}
