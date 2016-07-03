package com.diogenes.java8.capitulo8;

import java.util.function.IntSupplier;

/**
 * Created by diogenes on 03/07/16.
 */
public class Fibonacci implements IntSupplier {

    private int anterior = 0;
    private int proximo = 1;

    @Override
    public int getAsInt() {
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return anterior;
    }
}
