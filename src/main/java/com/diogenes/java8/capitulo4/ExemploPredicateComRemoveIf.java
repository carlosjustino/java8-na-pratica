package com.diogenes.java8.capitulo4;

import com.diogenes.java8.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by diogenes on 22/06/16.
 */
public class ExemploPredicateComRemoveIf {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 160;
            }
        };

        Predicate<Usuario> predicadoLambda = usuario -> usuario.getPontos() > 160;
        usuarios.removeIf(predicado);
        //ou usuarios.removeIf(usuario -> usuario.getPontos() > 160);
        usuarios.forEach(u -> System.out.println(u));
    }
}

