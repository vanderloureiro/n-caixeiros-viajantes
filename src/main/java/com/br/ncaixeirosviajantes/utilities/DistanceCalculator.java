package com.br.ncaixeirosviajantes.utilities;

import com.br.ncaixeirosviajantes.model.City;

public class DistanceCalculator {

    public static double calcularDistancia(City a, City b){
        //Retorna a distancia entre as cidades a e b
        return Math.sqrt(Math.pow((a.getX() - b.getX()),2) + Math.pow((a.getY() - b.getY()),2));
    }
}
