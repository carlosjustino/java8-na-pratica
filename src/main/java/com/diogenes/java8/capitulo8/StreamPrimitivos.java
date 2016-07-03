package com.diogenes.java8.capitulo8;

import java.util.PrimitiveIterator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by diogenes on 03/07/16.
 */
public class StreamPrimitivos {
    public static void main(String[] args) {

        //range e rangeClosed  - método factory
        IntStream intStream = IntStream.rangeClosed(1, 20);

        //Iterator para primitivos
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        Integer nextInteger = iterator.next();
        int intNext = iterator.nextInt();

        LongStream longStream = LongStream.empty();
        PrimitiveIterator.OfLong iterator1 = longStream.iterator();
        DoubleStream doubleStream = DoubleStream.empty();
    }
}
