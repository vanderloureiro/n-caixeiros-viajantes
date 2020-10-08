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
        int size    = 100;
        //String path = "/home/vanderlei/Workspace/ufc/n-caixeiros-viajantes/files/ncit"+size+".dat";
        String path = "C:\\Users\\Marcelo\\IdeaProjects\\n-caixeiros-viajantes\\files\\ncit"+size+".dat";
        runOneTraveler(path, size);
        runTwoTraveler(path, size);
        runThreeTraveler(path, size);
    }

    public static void runOneTraveler(String path, int size) {
        TravelerService travelerService = new OneTravelerService(path, size);
        List<City> calculateRoute = travelerService.calculateRoute();
        RouteResult routeResult   = travelerService.calculateValues(calculateRoute);
        writeResult(calculateRoute, routeResult);
    }

    public static void runTwoTraveler(String path, int size) {
        TravelerService travelerService = new TwoTravelerService(path, size);
        List<City> calculateRoute = travelerService.calculateRoute();
        RouteResult routeResult   = travelerService.calculateValues(calculateRoute);
        writeResult(calculateRoute, routeResult);
    }

    public static void runThreeTraveler(String path, int size) {
        TravelerService travelerService = new ThreeTravelerService(path, size);
        List<City> calculateRoute = travelerService.calculateRoute();
        RouteResult routeResult   = travelerService.calculateValues(calculateRoute);
        writeResult(calculateRoute, routeResult);
    }

    public static void writeResult(List<City> calculateRoute, RouteResult routeResult) {

        calculateRoute.stream().forEach(city -> {
            System.out.println(city.toString());
        });

        System.out.println("====================");
        System.out.println(routeResult.toString());
        System.out.println("====================");
    }
}
