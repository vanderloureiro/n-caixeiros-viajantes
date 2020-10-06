package com.br.ncaixeirosviajantes.services;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;

public class OneTravelerService extends TravelerService {

    public OneTravelerService(String completeFilePath) {
        super(completeFilePath);
    }
    
    @Override
    public List<City> calculateRoute() {
        List<City> cities = this.repository.findAll();
        
        this.visitedCities.add(cities.get(0));

        int size = cities.size();

        for (int i = 0; i < size; i++) {

            City currentCity = this.getCurrentCity();
            List<City> allCitiesUnvisited = this.getAllCitiesUnvisited();

            if (allCitiesUnvisited.size() > 0) {
                City bestStepByCurrentCity = this.distanceCalculator.getBestStepByCurrentCity(
                    currentCity, allCitiesUnvisited);
    
                this.visitedCities.add(bestStepByCurrentCity);
            }
        }

        this.visitedCities.add(visitedCities.get(0));

        return this.visitedCities;
    }
}
