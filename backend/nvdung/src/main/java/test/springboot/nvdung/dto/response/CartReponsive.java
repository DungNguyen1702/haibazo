package test.springboot.nvdung.dto.response;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartReponsive {
   private Integer id;
   private Integer quantity;
   private Integer productDetailId;
   private LocalDateTime createdAt;
   private LocalDateTime updateAt;
}
