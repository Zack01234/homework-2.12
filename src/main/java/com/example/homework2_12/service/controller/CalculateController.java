package com.example.homework2_12.service.controller;

import com.example.homework2_12.service.service.CalculateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String salute() {
        return "<h1>Ты решил воспользоваться мною, но ты делаешь это без уважения!..." +
                "Ну ладно, сегодня разрешаю.</h1>";
    }

    @GetMapping("/calculate/plus")
    public String addition(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (Object.isNull(a) || Object.isNull(b)) {
            return "Введите оба параметра.";
        }
        return buildResult(a, b, calculateService.addition(a, b), "+");
    }

    @GetMapping("/calculate/minus")
    public String subtraction(@RequestParam(name = "num1", required = false) Integer a,
                              @RequestParam(name = "num2", required = false) Integer b) {
        if (Object.isNull(a) || Object.isNull(b)) {
            return "Введите оба параметра.";
        }
        return buildResult(a, b, calculateService.subtraction(a, b), "-");
    }

    @GetMapping("/calculate/multiply")
    public String multiplication(@RequestParam(name = "num1", required = false) Integer a,
                                 @RequestParam(name = "num2", required = false) Integer b) {
        if (Object.isNull(a) || Object.isNull(b)) {
            return "Введите оба параметра.";
        }
        return buildResult(a, b, calculateService.multiplication(a, b), "*");
    }

    @GetMapping("/calculate/divide")
    public String division(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (Object.isNull(a) || Object.isNull(b)) {
            return "Введите оба параметра.";
        }
        return buildResult(a, b, calculateService.division(a, b), "/");
    }

    private String buildResult(Number a, Number b, Number result, String operation) {
        return String.format("%s %s %s = %s", a, operation, b, result);
    }
}
