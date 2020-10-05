package com.br.ncaixeirosviajantes.services;

import java.util.ArrayList;

import com.br.ncaixeirosviajantes.model.City;

public class DistanceCalculatorService {
    
    public double calcualteDistance(City a, City b){
        //Retorna a distancia entre as cidades a e b
        return Math.sqrt(Math.pow((a.getX() - b.getX()),2) + Math.pow((a.getY() - b.getY()),2));
    }

    public double[][] montarMatrizDistancias(ArrayList<City> cidades){
        int qtdCidades = cidades.size();

        double[][] matrizDistancias = new double[qtdCidades][qtdCidades];

        for(int i = 0; i < qtdCidades; i++){
            for(int j = 0; j < qtdCidades; j++){
                if(i == j){
                    matrizDistancias[i][j] = 0;
                }else{
                    City cityI = buscaCidade(i, cidades);
                    City cityJ = buscaCidade(j, cidades);

                    matrizDistancias[i][j] = calcualteDistance(cityI, cityJ);
                }
            }
        }
        return matrizDistancias;
    }

    private City buscaCidade(int id, ArrayList<City> cidades){
        for(City c : cidades){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
}