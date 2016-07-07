package com.diogenes.java8.capitulo9;

import java.util.stream.LongStream;

/**
 * Created by diogenes on 07/07/16.
 */
public class ParallelStreamPerformance {

    public static void main(String[] args) {


        //Input Grande de dados e a velocidade de execução da operação (soma é barata)
        System.out.println("Soma de números pares de 0 a 1 bilhão com parallel");
        long inicio = System.currentTimeMillis();
        long sum = LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Soma: " + sum + " Tempo: " + tempo);


        System.out.println("\nSoma de números pares de 0 a 1 bilhão sem parallel");
        inicio = System.currentTimeMillis();
        sum = LongStream.range(0, 1_000_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Soma: " + sum + " Tempo: " + tempo);

        System.out.println("\nSoma de números pares de 0 a 1 milhão com parallel");
        inicio = System.currentTimeMillis();
        sum = LongStream.range(0, 1_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Soma: " + sum + " Tempo: " + tempo);


        System.out.println("\nSoma de números pares de 0 a 1 milhão sem parallel");
        inicio = System.currentTimeMillis();
        sum = LongStream.range(0, 1_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Soma: " + sum + " Tempo: " + tempo);
    }
}
