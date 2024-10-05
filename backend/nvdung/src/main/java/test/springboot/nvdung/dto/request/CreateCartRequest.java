package test.springboot.nvdung.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCartRequest {
    private Integer productDetailId;
    private Integer quantity;
}
