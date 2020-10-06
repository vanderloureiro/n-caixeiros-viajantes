package com.br.ncaixeirosviajantes.services;

import java.util.List;

import com.br.ncaixeirosviajantes.model.City;

public class ThreeTravelerService extends TravelerService {
    
    public ThreeTravelerService(String completeFilePath) {
        super(completeFilePath);
    }

    @Override
    public List<City> calculateRoute() {
        return null;
    }
}
