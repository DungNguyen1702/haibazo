package test.springboot.nvdung.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import test.springboot.nvdung.dto.response.ConstantReposonse;
import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.model.*;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;
import test.springboot.nvdung.repository.ConstantRepository;
import test.springboot.nvdung.repository.ProductRepository;
import test.springboot.nvdung.service.ConstantService;

@Service
@RequiredArgsConstructor
public class ConstantServiceImpl implements ConstantService {

    @Autowired()
    private ConstantRepository constantRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseModel getSideBarData() {
        ResponseModel responseModel = new ResponseModel();

        List<Constant> categories = constantRepository.findByType(ConstantTypeEnum.CATEGORY);
        List<Constant> styles = constantRepository.findByType(ConstantTypeEnum.STYLE);
        List<Constant> sizes = constantRepository.findByType(ConstantTypeEnum.SIZE);
        List<Constant> colors = constantRepository.findByType(ConstantTypeEnum.COLOR);

        List<Product> products = productRepository.findAll();

        int minPrice = products.stream()
                .map(Product::getPrice)
                .reduce(Integer.MAX_VALUE, Integer::min);

        int maxPrice = products.stream()
                .map(Product::getPrice)
                .reduce(Integer.MIN_VALUE, Integer::max);

        Map<String, Object> result = new HashMap<>();
        result.put("categories", categories.stream().map((category) -> ConstantReposonse.builder()
                .id(category.getId())
                .type(category.getType())
                .value(category.getValue())
                .build()));
        result.put("styles", styles.stream().map((style) -> ConstantReposonse.builder()
                .id(style.getId())
                .type(style.getType())
                .value(style.getValue())
                .build()));
        result.put("sizes", sizes.stream().map((size) -> ConstantReposonse.builder()
                .id(size.getId())
                .type(size.getType())
                .value(size.getValue())
                .build()));
        result.put("colors", colors.stream().map((color) -> ConstantReposonse.builder()
                .id(color.getId())
                .type(color.getType())
                .value(color.getValue())
                .build()));
        result.put("minPrice", minPrice);
        result.put("maxPrice", maxPrice);

        responseModel.setResult(result);
        responseModel.setMessage("Lấy dữ liệu thành công");

        return responseModel;
    }

    @Override
    public ResponseModel getListConstant(ConstantTypeEnum type) {
        ResponseModel responseModel = new ResponseModel();

        List<Constant> constants = new ArrayList<>();

        if (type != null) {
            constants = constantRepository.findByType(type);
        } else {
            constants = constantRepository.findAll();
        }

        List<ConstantReposonse> constantRes = constants.stream().map((constant) -> ConstantReposonse
                .builder()
                .id(constant.getId())
                .type(constant.getType())
                .value(constant.getValue())
                .build())
                .toList();
        responseModel.setResult(constantRes);
        responseModel.setMessage("Truy vấn dữ liệu constant thành công");

        return responseModel;
    }
}
