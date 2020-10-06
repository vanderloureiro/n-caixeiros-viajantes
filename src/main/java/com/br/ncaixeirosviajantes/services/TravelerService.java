package com.br.ncaixeirosviajantes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;
import com.br.ncaixeirosviajantes.repository.CityRepository;

public abstract class TravelerService {

    protected ArrayList<City> visitedCities = new ArrayList<>();
    
    protected CityRepository repository;
    protected DistanceCalculatorService distanceCalculator;

    public TravelerService(String completeFilePath) {
        this.repository = new CityRepository(completeFilePath);
        this.distanceCalculator = new DistanceCalculatorService();
    }

    public List<City> calculateRoute() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public RouteResult calculateValues(List<City> visitedCities) {
        RouteResult routeResult = new RouteResult();
        
        Double distance = 0.0;

        int size = visitedCities.size();
        for (int index = 0; index < size - 1; index++) {
            distance += this.distanceCalculator.calcualteDistance(visitedCities.get(index), visitedCities.get(index + 1));
        }

        int days = (int) (distance / 600);

        routeResult.setTotalDistance(distance);
        routeResult.setDistanceByTraveler(distance);
        routeResult.setNumberOfDays(days);
        routeResult.setTotalValue(days * 150);

        return routeResult;
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