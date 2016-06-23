package com.diogenes.java8.capitulo4;

/**
 * Created by diogenes on 22/06/16.
 */

@FunctionalInterface
public interface InterfaceDefaultMehtod {

    void doSomething();

    default void defaultMethod() {
        System.out.println("Interface Default method - Métodos defaults foram  adicionados" +
                "para permitir que interfaces evoluam sem quebrar código existente");
    }

}
