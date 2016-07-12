package com.diogenes.java8.capitulo9;

import java.util.stream.LongStream;

/**
 * Created by diogenes on 12/07/16.
 */
public class UnsafeParallelStreamUsage {

    //Uso concorrente de uma variável compartilhada possibilita o interleaving de operações
    //de forma indesejada
    private static long total = 0;

    public static void main(String[] args) {
        LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .forEach(n -> total += n);

        System.out.println(total);
    }
}
