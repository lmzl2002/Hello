package com.zufarexplainedit.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/bmi")
    public ResponseEntity<String> calculateBMI(
            @RequestParam("height") double height,
            @RequestParam("weight") double weight) {
        
        // Calculate BMI
        double bmi = weight / (height * height);
        
        // Determine BMI category
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            category = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        // Construct response message
        String message = String.format("Your BMI is %.2f. You are %s.", bmi, category);
        
        return ResponseEntity.ok().body(message);
    }
}
