package com.diogenes.java8.capitulo7;

import com.diogenes.java8.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by diogenes on 29/06/16.
 */
public class Capitulo7 {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("José", 120));
        usuarios.add(new Usuario("João", 90));

        Stream<Usuario> stream = usuarios.stream();
        Predicate<Usuario> predicate = usuario -> {return usuario.getPontos() > 100;};

        //ou
        predicate = usuario -> usuario.getPontos() > 100;

        stream.filter(predicate);

        usuarios.forEach(System.out::println);

        System.out.println("\n#################\n");

        //ou

        /**
         * É muito importante saber que o Stream não tem efeito colateral sobre a coleção que originou
         * Por isso, sempre que aplicamos uma transformação em um Stream, como fizemos com o filter,
         * ele nos retorna um novo Stream como o resultado
         */
        Stream<Usuario> novaStream = usuarios.stream().filter(usuario -> usuario.getPontos() > 100);

        novaStream.forEach(System.out::println);


        //Collectors
        Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
        BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner = ArrayList::addAll;

        List<Usuario> maisQue100 = usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .collect(supplier, accumulator, combiner);

        //ou

        List<Usuario> maisQue100ComCollector = usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .collect(Collectors.toList());

        //ou escolhendo a implementacao da coleção

        usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .collect(Collectors.toCollection(HashSet::new));


        //Map
        //Ao invés de

        List<Integer> pontos = new ArrayList<>();
        usuarios.forEach(u -> pontos.add(u.getPontos()));

        //Podemos utilizar o método map da Stream sem uso de variaveis intermediarias
        List<Integer> pontosComMap = usuarios.stream()
                .map(Usuario::getPontos)
                .collect(Collectors.toList());

        //Para evitar boxing

        int[] pontosInt = usuarios.stream().mapToInt(Usuario::getPontos).toArray();


        //Metodos facilitadores do IntStream
        IntStream intStream = usuarios.stream().mapToInt(Usuario::getPontos);
        intStream.max();
        intStream.average();
        intStream.sorted();

        //Optional

        OptionalDouble media = intStream.average();
        double pontuacaoMedia = media.orElse(0.0);

        //ou
        media.orElseThrow(() -> new IllegalArgumentException("Media valor inválido"));

        media.ifPresent(System.out::println);


    }
}
