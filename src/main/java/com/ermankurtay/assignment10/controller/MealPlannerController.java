package com.ermankurtay.assignment10.controller;

import com.ermankurtay.assignment10.model.DayResponse;
import com.ermankurtay.assignment10.model.WeekResponse;
import com.ermankurtay.assignment10.spoonacular.SpoonacularIntegration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlannerController {

    private final SpoonacularIntegration spoonacularIntegration;

    public MealPlannerController(SpoonacularIntegration spoonacularIntegration) {
        this.spoonacularIntegration = spoonacularIntegration;
    }

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam String numCalories,
            @RequestParam String diet,
            @RequestParam String exclusions) {
        return spoonacularIntegration.getWeekMeals(numCalories, diet, exclusions);
    }

    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam String numCalories,
            @RequestParam String diet,
            @RequestParam String exclusions) {
        return spoonacularIntegration.getDayMeals(numCalories, diet, exclusions);
    }
}
