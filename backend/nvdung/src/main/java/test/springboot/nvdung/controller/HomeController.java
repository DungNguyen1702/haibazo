package test.springboot.nvdung.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {
    @GetMapping()
    public String getIndex() {
        return "Nguyen Van Dung -  Haibazo SpringBoot Intern Test API";
    }
    
}
