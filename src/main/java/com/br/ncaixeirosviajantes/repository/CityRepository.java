package com.br.ncaixeirosviajantes.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.br.ncaixeirosviajantes.model.City;

public class CityRepository {

    private List<City> cities;
    private String completeFilePath;

    public CityRepository(String completeFilePath) {
        this.completeFilePath = completeFilePath;
    }
    
    public List<City> findAll(){

        if (cities != null ){
            return cities;
        }

        ArrayList<City> cidades = new ArrayList<>();

        try {
            File myObj = new File(this.completeFilePath);
            Scanner myReader = new Scanner(myObj);

            if(myReader.hasNextLine()){
                myReader.nextLine();
            }
            //Lida a primeira linha da quantidade de cidades
            int identificadorCidade = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] coordenadas = data.split(" ");

                City novaCidade = new City();

                novaCidade.setX(Integer.parseInt(coordenadas[0]));
                novaCidade.setY(Integer.parseInt(coordenadas[1]));
                novaCidade.setId(identificadorCidade);
                cidades.add(novaCidade);
                identificadorCidade++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exceção ao ler o arquivo de entradas");
            e.printStackTrace();
        }

        return cidades;
    }

    public Optional<City> findById(int id) {

        if (cities == null ){
            this.findAll();
        }

        return this.cities
                    .stream()
                    .filter(city -> {
                        return city.getId() == id;
                    })
                    .findFirst();
    }
}