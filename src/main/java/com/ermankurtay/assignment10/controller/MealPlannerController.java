package com.ermankurtay.assignment10.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ermankurtay.assignment10.model.DayResponse;
import com.ermankurtay.assignment10.model.WeekResponse;

@RestController
public class MealPlannerController {

    private static final String API_KEY = "1a5d951cbf50420aaf54751c55e6b2dd";
    private static final String SPOONACULAR_API_URL = "https://api.spoonacular.com/mealplanner/generate";

    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam(value = "targetCalories", required = false) String numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(value = "exclude", required = false) String exclusions) {

        URI uri = buildUri("day", numCalories, diet, exclusions);

        return new RestTemplate().getForEntity(uri, DayResponse.class);
    }

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam(value = "targetCalories", required = false) String numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(value = "exclude", required = false) String exclusions) {

        URI uri = buildUri("week", numCalories, diet, exclusions);

        return new RestTemplate().getForEntity(uri, WeekResponse.class);
    }

    private URI buildUri(String timeFrame, String numCalories, String diet, String exclusions) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SPOONACULAR_API_URL)
                .queryParam("apiKey", API_KEY)
                .queryParam("timeFrame", timeFrame);

        if (numCalories != null) {
            builder.queryParam("targetCalories", numCalories);
        }

        if (diet != null) {
            builder.queryParam("diet", diet);
        }

        if (exclusions != null) {
            builder.queryParam("exclude", exclusions);
        }

        return builder.build().toUri();
    }
}
