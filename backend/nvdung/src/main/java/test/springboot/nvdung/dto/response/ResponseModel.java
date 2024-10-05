package test.springboot.nvdung.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ResponseModel {
    private Object result;
    private String message;
}