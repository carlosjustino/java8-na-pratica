package com.diogenes.java8.capitulo9;

import com.diogenes.java8.capitulo2.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diogenes on 06/07/16.
 */
public class Capitulo9 {
    public static void main(String[] args) throws IOException {
        Map<Path, Long> lines = Files.list(Paths.get("./src/main/java/com/diogenes/java8/capitulo8"))
                .filter(path -> path.toString().endsWith(".java"))
                .collect(Collectors.toMap(Function.identity(),
                        path -> lines(path).count()));

        lines.forEach((path, quantidadeLinhas) -> {System.out.println(path.toString() + " = " + quantidadeLinhas);});

        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<Usuario>> pontuacao = usuarios.stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));

        Map<Boolean, List<Usuario>> moderadores = usuarios.stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));

        Map<Boolean, List<String>> nomesPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.mapping(Usuario::getNome,
                                Collectors.toList())
                ));

        Map<Boolean, Integer> pontuacaoPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.summingInt(Usuario::getPontos)
                ));

        String nomes = usuarios.stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));

        //ParallelStream

        List<Usuario> filtradosOrdenados = usuarios.parallelStream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());


        //Stream paralelo faz uso do Spliterator e API Fork/Join

        Spliterator<Usuario> spliterator = usuarios.spliterator();

    }

    private static Stream<String> lines(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
