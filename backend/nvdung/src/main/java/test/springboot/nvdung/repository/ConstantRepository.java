package test.springboot.nvdung.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import test.springboot.nvdung.model.Constant;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;

public interface ConstantRepository extends JpaRepository<Constant, Integer> {
    List<Constant> findByType(ConstantTypeEnum constantTypeEnum);

    Optional<Constant> findByTypeAndValue(ConstantTypeEnum constantTypeEnum, String value);
}
