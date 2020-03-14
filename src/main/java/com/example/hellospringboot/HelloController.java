package com.example.hellospringboot;

import com.example.hellospringboot.exception.BadRequestException;
import com.example.hellospringboot.jpa.entity.BillionaireEntity;
import com.example.hellospringboot.jpa.service.BillionaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {
    private final HelloService helloService;
    private final BillionaireService billionaireService;

    public HelloController(HelloService helloService, BillionaireService billionaireService) {
        this.helloService = helloService;
        this.billionaireService = billionaireService;
    }

    @PostMapping(path = "/world")
    public @ResponseBody String getString() {
        System.out.println("Inside of getString");
        return helloService.postHandling();
    }

    //http://localhost:8080/hello/somename?name=huy
    @GetMapping(path = "/somename")
    public @ResponseBody String greet(@RequestParam Map<String, String> queryParameters) {
        System.out.println("Inside of greet");
        return helloService.getHandling(queryParameters.get("name"));
    }

    @GetMapping(path = "/exception")
    public @ResponseBody String causeExceptionByParam(@RequestParam Map<String, String> queryParameters) {
        System.out.println("Inside of causeExceptionByParam");
        return helloService.causeExceptionByParam(queryParameters.get("httpstatus"));
    }

    @GetMapping("/exception/{id}")
    public String causeExceptionByPath(@PathVariable Long id) {
        System.out.println("Inside of causeExceptionByPath");
        throw new BadRequestException("Employee id '" + id + "' does not exist");
    }

    //http://localhost:8080/hello/billionaires
    @GetMapping(path = "/billionaires")
    public @ResponseBody List<BillionaireEntity> retrieveBillionaires(@RequestParam Map<String, String> queryParameters) {
        System.out.println("Inside of retrieveBillionaires");
        Optional<List<BillionaireEntity>>  billionaireEntities = billionaireService.retrieve(null);

        return billionaireEntities.orElse(Collections.emptyList());
    }
}