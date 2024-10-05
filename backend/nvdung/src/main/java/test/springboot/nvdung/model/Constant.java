package test.springboot.nvdung.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;

@Entity
@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Table(name = "constants")
public class Constant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ConstantTypeEnum type;

    @Column()
    private String value;

    @OneToMany(mappedBy = "style", fetch = FetchType.LAZY)
    private List<Product> styleProducts;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> categoryProducts;

    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<ProductDetail> sizeProducts;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private List<ProductDetail> colorProducts;
}
