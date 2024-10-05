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
public class ProductDTO {
    private Integer id;
    private Integer price;
    @Builder.Default()
    private Integer discount = 0;
    private Integer salePrice;
    private String name;
    private ProductGender gender;
    private String description;
    @Builder.Default()
    private LocalDate discountTo = null;
    @Builder.Default()
    private double rating = 5;
    @Builder.Default()
    private Integer ratingCount = 0;
    @Builder.Default()
    private Integer viewedCount = 0;
    private List<String> images;
    private String style;
    private String category;
}
