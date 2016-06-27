package com.diogenes.java8.capitulo6;

import com.diogenes.java8.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparing;

/**
 * Created by diogenes on 27/06/16.
 */
public class Capitulo6 {
    public static void main(String[] args) {
        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.forEach(tornaModerador);
        //ou
        usuarios.forEach(Usuario::tornaModerador);

        usuarios.sort(comparing(u -> u.getNome()));
        //ou
        usuarios.sort(comparing(Usuario::getNome));
        //ou
        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));

        //Composicao de comparators
        ToIntFunction<Usuario> byPontos = Usuario::getPontos;
        usuarios.sort(comparing(byName).thenComparingInt(byPontos));

        //NullLast Comparator
        usuarios.sort(Comparator.nullsLast(comparing(byName)));

        usuarios.forEach(System.out::println);

        //Constructor reference
        Supplier<Usuario> criadorUsuarios = Usuario::new;
    }
}
