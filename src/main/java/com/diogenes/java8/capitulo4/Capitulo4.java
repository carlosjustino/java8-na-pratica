package com.diogenes.java8.capitulo4;

import com.diogenes.java8.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by diogenes on 22/06/16.
 */
public class Capitulo4 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostradorMensagem = u -> System.out.println("antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        usuarios.forEach(mostradorMensagem.andThen(imprimeNome));

    }
}
