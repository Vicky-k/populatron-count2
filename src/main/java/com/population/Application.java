package com.population;


import java.io.IOException;

public class Application {

    public static void main(String args[])  throws IOException {
        String num = PopulationCounter.getPopulation(args[0]);
        System.out.printf("World population is: %s\n", num);

    }
}
