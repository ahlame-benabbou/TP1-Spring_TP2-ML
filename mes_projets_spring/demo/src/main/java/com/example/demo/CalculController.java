
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculController {

    @GetMapping("/add")
    public String somme(
            @RequestParam(defaultValue = "0") int num1,
            @RequestParam(defaultValue = "0") int num2,
            Model model) {

        model.addAttribute("somme1", num1 + num2);
        model.addAttribute("somme2", num1 + num2);

        return "result";
    }
}
