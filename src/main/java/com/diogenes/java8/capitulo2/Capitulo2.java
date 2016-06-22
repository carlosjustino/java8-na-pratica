package com.diogenes.java8.capitulo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by diogenes on 21/06/16.
 */
public class Capitulo2 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        System.out.println("Iteracao tradicional");

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }

        System.out.println("Iteracao com a Interface Consumer");

        Consumer<Usuario> mostrador = new Consumer<Usuario>() {
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };

        usuarios.forEach(mostrador);

        System.out.println("Iteracao com Lambda");

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));
    }
}
