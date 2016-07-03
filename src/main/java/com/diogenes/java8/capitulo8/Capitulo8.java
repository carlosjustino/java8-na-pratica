package com.diogenes.java8.capitulo8;

import com.diogenes.java8.capitulo2.Usuario;

import java.nio.file.Files;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diogenes on 03/07/16.
 */
public class Capitulo8 {

    public static void main(String[] args) {
        //Ordenando um stream
        List<Usuario> usuarios = new ArrayList<>();

        //pipeline de operacoes de stream
        // todas essas operacoes sao lazy - nao foram executadas ainda - operacoes intermediárias
        // sao executadas quando for preciso obter o resultado final - operação terminal
        Stream<Usuario> sortedStream = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome));


        //operacao terminal, neste momento a stream executa o pipeline de operacoes pedido
        sortedStream.collect(Collectors.toList());

        //Find Any - Encontrar usuarios com mais de 100 pontos

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .collect(Collectors.toList())
                .get(0);

        //Usando findAny - para a filtragem da lista quando encontra
        //retorna um optional
        //Temos ainda o método findFirst
        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .findAny();

        //Executar uma tarefa para cada elemento processado pela stream
        //metodo peek

        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .peek(System.out::println)
                .findFirst();

        //sorted é um método intermediaria stateful - precisa processar toda a stream
        //diferentemente do findAny que é uma operação terminal lazy que não demanda o processamento de toda stream
        //essa stream não consegue tirar proveito do layziness, pois há uma operação stateful em seu pipeline
        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();

        //operacoes de reducao = operacoes que utilizam os elementos da stream para retornar um valor final (reduction) outras linguagens: fold
        //average, sum, min, max, count

        //average e sum apenas em stream primitivos
        //sum e count não utilizao optional

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparing(Usuario::getPontos));
        Usuario maximaPontuacao = max.get();

        int total = usuarios.stream()
                            .mapToInt(Usuario::getPontos)
                            .sum();

        //De maneira explícita
        int valorInicial = 0;
        //Interface funcional que define o método applyAsInt
        IntBinaryOperator operacao = (a, b) -> a + b;

        total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(valorInicial, operacao);

        // ou método estático sum classe Integer

        total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, Integer::sum);

        //Em alguns casos pode ser custoso chamar o map
        //podemos executar a soma assim

        total = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);

        //Iterator Stream
        // Um motivo para usar um Iterator da stream é quando queremos modificar os objetos
        usuarios.stream().iterator()
                .forEachRemaining(System.out::println);

        //Testando predicatos

        //anyMatch - para a execucao assim que encontrar um elemento
        boolean hasModerator = usuarios.stream()
                .anyMatch(Usuario::isModerador);

        boolean todosSaoModeradores = usuarios.stream()
                .allMatch(Usuario::isModerador);

        boolean nenhumModerador = usuarios.stream()
                .noneMatch(Usuario::isModerador);

        //skip - pula os n próximos elementos
        usuarios.stream().skip(5);

        //limit - cortar o número de elementos
        usuarios.stream().limit(2);

        Stream streamVazia = Stream.empty();

        Stream<Usuario> usuarioStream = Stream.of(new Usuario(), new Usuario());

        Stream concat = Stream.concat(streamVazia, usuarioStream);

        String valor = "${expressao} + 1;";

        Pattern regex = Pattern.compile("\\$\\{.*?\\}");
        Stream<String> expressoes = regex.splitAsStream(valor);

        //Retorna uma stream de string - linhas de um arquivo
        //Files.lines()

        Usuario[] arrayUsuarios = {new Usuario(), new Usuario()};
        Stream<Usuario> streamArray = Arrays.stream(arrayUsuarios);

        //Stream implementa AutoCloseable - importante quando lidando com Streams gerado a partir de recursos de IO. exemplo Files

        //eliminar duplicatas
        streamArray.distinct();


    }
}
