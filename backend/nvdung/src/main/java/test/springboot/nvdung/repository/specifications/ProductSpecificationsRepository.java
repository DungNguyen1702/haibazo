package test.springboot.nvdung.repository.specifications;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import test.springboot.nvdung.model.Product;

public interface ProductSpecificationsRepository
        extends CrudRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
