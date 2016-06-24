package com.diogenes.java8.capitulo5;

import com.diogenes.java8.capitulo2.Usuario;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * Created by diogenes on 23/06/16.
 */
public class Capitulo5 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };

        Collections.sort(usuarios, comparator);

        //OU
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        //OU
        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        //OU
        usuarios.sort(Comparator.comparing(u -> u.getNome()));

        //Gera Autoboxing - pontos é um int
        Function<Usuario, Integer> extraiPontosInteger = u -> u.getPontos();
        Comparator.comparing(extraiPontosInteger);

        //Para evitar Autoboxing
        ToIntFunction<Usuario> extraiPontosInt = u -> u.getPontos();
        Comparator.comparingInt(extraiPontosInt);

        usuarios.forEach(u -> System.out.println(u.getNome()));
    }
}
