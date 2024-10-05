package test.springboot.nvdung.controller;

import org.springframework.web.bind.annotation.*;

import test.springboot.nvdung.dto.response.ResponseModel;
import test.springboot.nvdung.model.Enum.ConstantTypeEnum;
import test.springboot.nvdung.service.ConstantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/constants")
public class ConstantController {
    @Autowired()
    private ConstantService constantService;

    @GetMapping("/sidebar")
    public ResponseModel getDataSideBar() {
        return this.constantService.getSideBarData();
    }
    
    @GetMapping()
    public ResponseModel getListConstant(@RequestParam(required = false) ConstantTypeEnum type) {
        return this.constantService.getListConstant(type);
    }
}
