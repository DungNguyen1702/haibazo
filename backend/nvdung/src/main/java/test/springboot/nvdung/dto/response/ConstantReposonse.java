package test.springboot.nvdung.dto.response;

import lombok.*;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConstantReposonse {
    private Integer id;
    private ConstantTypeEnum type;
    private String value;
}
