package test.springboot.nvdung.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Integer id;
    private Integer quantity;
    private String color;
    private String size;
    private Integer productId;
}