package test.springboot.nvdung.service;

import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;

public interface ConstantService {
    ResponseModel getSideBarData();

    ResponseModel getListConstant(ConstantTypeEnum type);
}
