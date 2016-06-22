package com.diogenes.java8.capitulo3;

import java.io.IOException;

/**
 * Created by diogenes on 21/06/16.
 */
public class ExemploRunnable {

    public static void main(String[] args) throws IOException {
        /*  Qualquer interface com apenas um método (abstrato e publico) é uma interface funcional
         *  e pode ser usado uma lambda expression
         */
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        };

        Runnable rTradicional = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {

                }
            }
        };

        System.out.println(r);
        System.out.println(r.getClass());
        System.out.println(rTradicional);
        System.out.println(rTradicional.getClass());

        System.in.read();

        new Thread(r).start();
    }
}
