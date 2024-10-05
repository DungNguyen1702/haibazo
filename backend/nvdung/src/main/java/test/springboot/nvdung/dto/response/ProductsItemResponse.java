package test.springboot.nvdung.dto.response;

import java.util.List;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ProductsItemResponse {
    private Integer id;
    private Double rating;
    private String name;
    private Integer price;
    private Integer discount;
    private Integer salesPrice;
    private List<String> productImages;
}
