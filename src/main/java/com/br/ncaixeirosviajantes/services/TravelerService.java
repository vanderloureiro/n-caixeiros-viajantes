package com.br.ncaixeirosviajantes.services;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    private List<City> getAllCitiesUnvisited() {
        return null;
    }

}