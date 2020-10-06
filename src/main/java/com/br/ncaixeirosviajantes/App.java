package com.br.ncaixeirosviajantes;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;
import com.br.ncaixeirosviajantes.services.OneTravelerService;
import com.br.ncaixeirosviajantes.services.ThreeTravelerService;
import com.br.ncaixeirosviajantes.services.TravelerService;
import com.br.ncaixeirosviajantes.services.TwoTravelerService;

public class App {
    public static void main(String[] args) {
        String path = "/home/vanderlei/Workspace/ufc/n-caixeiros-viajantes/files/ncit30.dat";
        runOneTraveler(path);
        runTwoTraveler(path);
        runThreeTraveler(path);
    }

    public static void runOneTraveler(String path) {
        TravelerService travelerService = new OneTravelerService(path);

        List<City> calculateRoute = travelerService.calculateRoute();

        calculateRoute.stream().forEach(city -> {
            System.out.println(city.toString());
        });

        RouteResult routeResult = travelerService.calculateValues(calculateRoute);
        System.out.println("====================");
        System.out.println(routeResult.toString());
        System.out.println("====================");
    }

    public static void runTwoTraveler(String path) {
        TravelerService travelerService = new TwoTravelerService(path);

        List<City> calculateRoute = travelerService.calculateRoute();

        calculateRoute.stream().forEach(city -> {
            System.out.println(city.toString());
        });

        RouteResult routeResult = travelerService.calculateValues(calculateRoute);
        System.out.println("====================");
        System.out.println(routeResult.toString());
        System.out.println("====================");
    }

    public static void runThreeTraveler(String path) {
        TravelerService travelerService = new ThreeTravelerService(path);

        List<City> calculateRoute = travelerService.calculateRoute();

        calculateRoute.stream().forEach(city -> {
            System.out.println(city.toString());
        });

        RouteResult routeResult = travelerService.calculateValues(calculateRoute);
        System.out.println("====================");
        System.out.println(routeResult.toString());
        System.out.println("====================");
    }
}
