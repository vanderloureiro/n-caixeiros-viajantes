package com.br.ncaixeirosviajantes.services;

import java.util.List;
import java.util.stream.Collectors;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;

public class TwoTravelerService extends TravelerService {
    
    public TwoTravelerService(String completeFilePath, int size) {
        super(completeFilePath, size);
    }

    @Override
    public List<City> calculateRoute() {
        List<City> cities = this.repository.findAll();

        this.visitedCities.add(cities.get(0));

        List<City> cities1 = cities.stream().filter(city -> {
                                return city.getId() < (this.sizeOfData / 2);
                            })
                            .collect(Collectors.toList());

        List<City> cities2 = cities.stream().filter(city -> {
                                return city.getId() >= (this.sizeOfData / 2);
                            })
                            .collect(Collectors.toList());

        this.calculatePartialRoute(cities1);
        this.calculatePartialRoute(cities2);

        this.visitedCities.add(visitedCities.get(0));

        return this.visitedCities;
    }

    private void calculatePartialRoute(List<City> cities) {

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
        routeResult.setDistanceByTraveler(distance / 2);
        routeResult.setNumberOfDays(days);
        routeResult.setTotalValue(days * 150);

        return routeResult;
    }
}
