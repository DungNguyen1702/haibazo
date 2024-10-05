package test.springboot.nvdung.repository.specifications;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;
import test.springboot.nvdung.model.Product;
import test.springboot.nvdung.model.ProductDetail;

public class ProductSpecifications {
    public static Specification<Product> filterByCategory(Integer categoryId) {
        return (root, query, criteriaBuilder) -> {
            if (categoryId == null) {
                return criteriaBuilder.conjunction();
            }
            
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }

    public static Specification<Product> filterByStyle(Integer styleId) {
        return (root, query, criteriaBuilder) ->{
            if (styleId == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(root.get("style").get("id"), styleId);
        };
    }

    public static Specification<Product> filterBySize(Integer sizeId) {
        return (root, query, criteriaBuilder) -> {
            if (sizeId == null) {
                return criteriaBuilder.conjunction();
            }

            Join<Product, ProductDetail> productDetailsJoin = root.join("productDetails");
            return criteriaBuilder.equal(productDetailsJoin.get("size").get("id"), sizeId);
        };
    }

    public static Specification<Product> filterByColor(Integer colorId) {
        return (root, query, criteriaBuilder) -> {
            if (colorId == null) {
                return criteriaBuilder.conjunction();
            }

            Join<Product, ProductDetail> productDetailsJoin = root.join("productDetails");
            return criteriaBuilder.equal(productDetailsJoin.get("color").get("id"), colorId);
        };
    }

    public static Specification<Product> filterByPriceRange(Integer minPrice, Integer maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            return null;
        };
    }

    public static Specification<Product> isNotDeleted() {
        return (root, query, builder) -> builder.isFalse(root.get("isDeleted"));
    }    
}
