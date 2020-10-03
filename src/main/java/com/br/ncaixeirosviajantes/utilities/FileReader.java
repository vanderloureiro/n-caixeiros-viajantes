package com.br.ncaixeirosviajantes.utilities;

import com.br.ncaixeirosviajantes.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<City> readFile(String completePath){
        ArrayList<City> cidades = new ArrayList<>();

        try {
            File myObj = new File(completePath);
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
}
