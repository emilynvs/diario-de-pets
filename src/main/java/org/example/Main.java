package org.example;

import org.example.controller.ContaController;
import org.example.controller.PostController;
import org.example.model.enuns.Animal;
import org.example.model.entity.Conta;
import org.example.model.entity.Post;

import com.google.cloud.Date;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        new FirebaseConfig().initialize();

        Scanner sc = new Scanner(System.in);
        ContaController contaController = new ContaController();
        PostController postController = new PostController();

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("      MENU PRINCIPAL");
            System.out.println("==============================");
            System.out.println("1 - Listar contas");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Atualizar conta");
            System.out.println("4 - Deletar conta");
            System.out.println("5 - Criar post");
            System.out.println("6 - Listar posts de uma conta");
            System.out.println("7 - Atualizar post");
            System.out.println("8 - Deletar post");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {


                case 1 -> {
                    System.out.println("\n --- LISTA DE CONTAS ---");
                    contaController.listarConta();
                }


                case 2 -> {
                    System.out.print("Usuário: ");
                    String user = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    System.out.println("Animal (CACHORRO, GATO, PEIXE, AVES, OUTRO): ");
                    String animalStr = sc.nextLine();
                    Animal animal = Animal.valueOf(animalStr.toUpperCase());

                    contaController.criarConta(user, animal, senha);
                }


                case 3 -> {
                    System.out.println("Ainda em desenvolvimento");
                }


                case 4 -> {
                    System.out.println("Ainda em desenvolvimento");
                }


                case 5 -> {
                    System.out.print("ID da conta dona do post: ");
                    String contaId = sc.nextLine();

                    System.out.print("Legenda: ");
                    String legenda = sc.nextLine();

                    System.out.print("URL da imagem (ou vazio): ");
                    String imagem = sc.nextLine();
                    if (imagem.isBlank()) imagem = null;

                    Date data = Date.fromYearMonthDay(2025, 12, 10);

                    postController.criarPost(contaId, legenda, imagem, data);
                }


                case 6 -> {
                    System.out.println("Ainda em desenvolvimento");
//                    System.out.print("ID da conta: ");
//                    String contaId = sc.nextLine();

//                    postController.listarPostsDaConta(contaId);
                }


                case 7 -> {
                    System.out.print("ID do post: ");
                    String postId = sc.nextLine();

                    System.out.print("ID da conta: ");
                    String contaId = sc.nextLine();

                    System.out.print("Nova legenda: ");
                    String legenda = sc.nextLine();

                    System.out.print("Nova imagem (ou vazio): ");
                    String imagem = sc.nextLine();
                    if (imagem.isBlank()) imagem = null;

                    LocalDate hoje = LocalDate.now();
                    Date data = Date.fromYearMonthDay(hoje.getYear(), hoje.getMonthValue(), hoje.getDayOfMonth());

                    Post post = new Post(contaId, legenda, imagem, data);
                    post.setId(postId);

                    postController.atualizarPost(post);
                }

                case 8 -> {
                    System.out.print("ID do post: ");
                    String postId = sc.nextLine();

                    postController.deletarPost(postId);
                }

                case 0 -> {
                    System.out.println("Saindo...");
                }

                default -> {
                    System.out.println("Opção inválida!");
                }
            }
        } while (opcao != 0);

        sc.close();
    }
}

