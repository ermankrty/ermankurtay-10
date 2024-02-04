package com.ermankurtay.assignment10.model;

import java.util.List;
import java.util.Map;

public class WeekResponse {
    private Map<String, Day> week;

    public Map<String, Day> getWeek() {
        return week;
    }

    public void setWeek(Map<String, Day> week) {
        this.week = week;
    }

    public static class Day {
        private List<Meal> meals;
        private Nutrients nutrients;

        public List<Meal> getMeals() {
            return meals;
        }

        public void setMeals(List<Meal> meals) {
            this.meals = meals;
        }

        public Nutrients getNutrients() {
            return nutrients;
        }

        public void setNutrients(Nutrients nutrients) {
            this.nutrients = nutrients;
        }
    }

    public static class Meal {
        private int id;
        private String imageType;
        private String title;
        private int readyInMinutes;
        private int servings;
        private String sourceUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageType() {
            return imageType;
        }

        public void setImageType(String imageType) {
            this.imageType = imageType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getReadyInMinutes() {
            return readyInMinutes;
        }

        public void setReadyInMinutes(int readyInMinutes) {
            this.readyInMinutes = readyInMinutes;
        }

        public int getServings() {
            return servings;
        }

        public void setServings(int servings) {
            this.servings = servings;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }
    }

    
}
