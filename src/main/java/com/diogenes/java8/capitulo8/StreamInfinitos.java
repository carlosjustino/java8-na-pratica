package com.diogenes.java8.capitulo8;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by diogenes on 03/07/16.
 */
public class StreamInfinitos {

    public static void main(String[] args) {
        Random random = new Random(0);
        Supplier<Integer> supplier = () -> random.nextInt();

        //generate é lazy
        Stream<Integer> stream = Stream.generate(supplier);

        //Sem gerar boxing para cada geracao

        IntStream streamInt = IntStream.generate(() -> random.nextInt());

        //Realizar o boxing caso preciso existe o método boxed
        //Stream<Integer> boxed = streamInt.limit(100).boxed();

        //executará infinitamente, pois precisa passar por todos os elementos da stream
        //int valor = streamInt.sum();

        //Devemos usar um operacao de curto circuito
        //Operacoes que nao precisam processar todos os elementos
        streamInt.limit(100).forEach(System.out::println);

        //Supplier que precisa guardar estado - Exemplo Fibonacci
        System.out.println("Série de Fibonacci\n");
        IntStream.generate(new Fibonacci())
                .limit(10)
                .forEach(System.out::println);

        //Além do limit há outras operacoes curto-circuito
        //Exemplo findFirst

        int maiorQue100 = IntStream
                .generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst()
                .getAsInt();
        System.out.println("Primeiro Elemento maior que 100 Fibonacci: " + maiorQue100);

        //Quando preciso manter o estado de apenas uma varíavel podemos usar o iterate
        IntStream.iterate(0, x -> x + 1)
                .limit(10)
                .forEach(System.out::println);

        IntStream intStream = new Random().ints();


    }
}
