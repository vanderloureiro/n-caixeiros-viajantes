package com.br.ncaixeirosviajantes;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;
import com.br.ncaixeirosviajantes.services.TravelerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path = "/home/vanderlei/Workspace/ufc/n-caixeiros-viajantes/files/ncit100.dat";

        TravelerService travelerService = new TravelerService(path);

        List<City> calculateRoute = travelerService.calculateRoute();

        calculateRoute.stream().forEach(city -> {
            System.out.println(city.toString());
        });
    }
}
