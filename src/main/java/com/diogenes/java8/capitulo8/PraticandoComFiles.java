package com.diogenes.java8.capitulo8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by diogenes on 03/07/16.
 */
public class PraticandoComFiles {
    public static void main(String[] args) throws IOException {
        //Listar todos os arquivos de um diretorio

        Files.list(Paths.get("")).forEach(System.out::println);

        System.out.println("\nSomente arquivos .xml\n");
        Files.list(Paths.get(""))
                .filter(p -> p.toString().endsWith(".xml"))
                .forEach(System.out::println);

        System.out.println("\nTodo o conteúdo dos arquivos das classes produzidas no capítulo 8\n");

        //Nao compila Files.lines lança IOException a Interface Function nao lanca exception
      /*  Files.list(Paths.get("./src/main/java/com/diogenes/java8/capitulo8"))
                .map(path -> Files.lines(path))
                .forEach(System.out::println);*/

        //Vai imprimir algo como: java.util.stream.ReferencePipeline$Head@1480cf9
        // pois o lines retorna um Stream<Sring> o forEach itera um Stream<Stream<String>>
        Files.list(Paths.get("./src/main/java/com/diogenes/java8/capitulo8"))
                .map(path -> lines(path))
                .forEach(System.out::println);

       //Podemos usar um flatMap nesse caso para ter um Stream<String>
        Files.list(Paths.get("./src/main/java/com/diogenes/java8/capitulo8"))
                .flatMap(path -> lines(path))
                .forEach(System.out::println);


    }

    private static Stream<String> lines(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
