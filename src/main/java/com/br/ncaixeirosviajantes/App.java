package com.br.ncaixeirosviajantes;

import com.br.ncaixeirosviajantes.services.TravelerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path = "/home/vanderlei/Workspace/ufc/n-caixeiros-viajantes/files/ncit30.dat";

        TravelerService travelerService = new TravelerService(path);

        travelerService.calculateRoute();

        System.out.println( "Hello World!" );
    }
}
