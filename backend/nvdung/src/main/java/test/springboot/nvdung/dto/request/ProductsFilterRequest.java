package test.springboot.nvdung.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsFilterRequest {
    private Integer categoryId;
    private Integer sizeId;
    private Integer styleId;
    private Integer colorId;
    private Integer maxPrice;
    private Integer minPrice;
    @Builder.Default
    private String sortBy="price";

    @Builder.Default
    private String sortOrder = "asc";
}
