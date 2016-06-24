package com.diogenes.java8.capitulo5;

import com.diogenes.java8.capitulo2.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by diogenes on 23/06/16.
 */
public class OrdenacaoNatural {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
        Collections.sort(palavras);

        //Classe String já é um Comparator
        palavras.sort(Comparator.naturalOrder());


    }
}
