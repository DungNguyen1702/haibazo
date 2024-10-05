package test.springboot.nvdung.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import test.springboot.nvdung.model.Enum.ProductGender;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private Integer price;
    @Column()
    private Integer discount;
    @Column()
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductGender gender;
    @Column()
    private String description;
    @Column()
    private LocalDate discountTo;

    @Builder.Default
    @Column()
    private boolean isDeleted = false;

    @Builder.Default
    @Column()
    private double rating = 5;

    @Builder.Default
    @Column()
    private Integer ratingCount = 0;

    @Builder.Default
    @Column()
    private Integer viewedCount = 0;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductDetail> productDetails;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Constant style;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Constant category;

    public Integer getDiscount() {
        
        if (discountTo != null && discountTo.isBefore(LocalDate.now())) {
            return 0; 
        }
        return this.discount;
    }

    public Integer getSalePrice() {
        if (discountTo != null && discountTo.isBefore(LocalDate.now())) {
            return this.price;
        }
        return this.price * (100 - this.discount) / 100;
    }
}
