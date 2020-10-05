package com.br.ncaixeirosviajantes.services;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;

public class DistanceCalculatorService {
    
    public double calcualteDistance(City a, City b){
        //Retorna a distancia entre as cidades a e b
        return Math.sqrt(Math.pow((a.getX() - b.getX()),2) + Math.pow((a.getY() - b.getY()),2));
    }
    
    public City getBestStepByCurrentCity(City currentCity, List<City> neighboringCities) {
        Double minDistance   = this.calcualteDistance(currentCity, neighboringCities.get(0));
        City minDistanceCity = neighboringCities.get(0);

        for (City neighboringCity : neighboringCities ) {
            double calcualteDistance = this.calcualteDistance(currentCity, neighboringCity);
            if (calcualteDistance < minDistance) {
                minDistance     = calcualteDistance;
                minDistanceCity = neighboringCity;
            }
        }

        return minDistanceCity;
    }
}