package com.br.ncaixeirosviajantes;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.model.RouteResult;
import com.br.ncaixeirosviajantes.services.TravelerService;

public class App 
{
    public static void main( String[] args )
    {
        String path = "/home/vanderlei/Workspace/ufc/n-caixeiros-viajantes/files/ncit30.dat";

        TravelerService travelerService = new TravelerService(path);

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
