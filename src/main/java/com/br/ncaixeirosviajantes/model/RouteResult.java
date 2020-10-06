package com.br.ncaixeirosviajantes.model;

import lombok.Data;

@Data
public class RouteResult {
    
    private double totalDistance;
    private double distanceByTraveler;
    private int numberOfDays;
    private double totalValue;

    public String toString() {
        String string = "[totalDistance]=" + String.format("%.4f", this.totalDistance);
        string += " [distanceByTraveler]=" + String.format("%.4f", this.distanceByTraveler);
        string += " [numberOfDays]=" + this.numberOfDays;
        string += " [totalValue]=" + this.totalValue;
        return string;
    }
}
