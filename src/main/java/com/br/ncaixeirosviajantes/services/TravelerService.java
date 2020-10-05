package com.br.ncaixeirosviajantes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.repository.CityRepository;

public class TravelerService {

    private ArrayList<City> visitedCities = new ArrayList<>();
    
    private CityRepository repository;
    private DistanceCalculatorService distanceCalculator;

    public TravelerService(String completeFilePath) {
        this.repository = new CityRepository(completeFilePath);
        this.distanceCalculator = new DistanceCalculatorService();
    }

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

    private City getCurrentCity() {
        return this.visitedCities.get(this.visitedCities.size() - 1);
    }

    private List<City> getAllCitiesUnvisited() {
        List<City> allCities = this.repository.findAll();

        return allCities
                .stream()
                .filter(city -> !this.visitedCities.contains(city))
                .collect(Collectors.toList());
    }

}