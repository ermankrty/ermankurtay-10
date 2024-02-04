package com.ermankurtay.assignment10.spoonacular;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ermankurtay.assignment10.model.DayResponse;
import com.ermankurtay.assignment10.model.WeekResponse;

import java.net.URI;

@Component
public class SpoonacularIntegration {

    private static final String API_KEY = "cb99e70922124baea8697cb8414c92bc";

    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return callApi(numCalories, diet, exclusions, "week", WeekResponse.class);
    }

    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return callApi(numCalories, diet, exclusions, "day", DayResponse.class);
    }

    private <T> ResponseEntity<T> callApi(String numCalories, String diet, String exclusions, String timeFrame, Class<T> responseType) {
    	
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("apiKey", API_KEY)
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();

        return restTemplate.getForEntity(uri, responseType);
    }
}
