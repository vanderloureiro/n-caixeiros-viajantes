package com.br.ncaixeirosviajantes.services;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;

public class OneTravelerService extends TravelerService {

    public OneTravelerService(String completeFilePath, int size) {
        super(completeFilePath, size);
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

    @Override
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
}
