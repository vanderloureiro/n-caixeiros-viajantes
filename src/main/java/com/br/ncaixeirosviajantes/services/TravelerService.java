package com.br.ncaixeirosviajantes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;
import com.br.ncaixeirosviajantes.repository.CityRepository;

public abstract class TravelerService {

    protected ArrayList<City> visitedCities = new ArrayList<>();
    protected int sizeOfData = 0;
    
    protected CityRepository repository;
    protected DistanceCalculatorService distanceCalculator;

    public TravelerService(String completeFilePath, int size) {
        this.sizeOfData = size;
        this.repository = new CityRepository(completeFilePath);
        this.distanceCalculator = new DistanceCalculatorService();
    }

    public List<City> calculateRoute() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public RouteResult calculateValues(List<City> visitedCities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    protected City getCurrentCity() {
        return this.visitedCities.get(this.visitedCities.size() - 1);
    }

    protected List<City> getAllCitiesUnvisited() {
        List<City> allCities = this.repository.findAll();

        return allCities
                .stream()
                .filter(city -> !this.visitedCities.contains(city))
                .collect(Collectors.toList());
    }

}