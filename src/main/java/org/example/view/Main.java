package org.example.view;

import org.example.config.FirestoreConfig;
import org.example.controller.ContaController;
import org.example.controller.PostController;
import org.example.model.enuns.Animal;
import org.example.model.entity.Post;


import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        FirestoreConfig.initialize();

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
            System.out.println("3 - Atualizar nome de usuário");
            System.out.println("4 - Deletar conta");
            System.out.println("5 - Criar post");
            System.out.println("6 - Listar posts de uma conta");
            System.out.println("7 - Atualizar post");
            System.out.println("8 - Deletar post");
            System.out.println("0 - Sair");

            try {
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                sc.nextLine();
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    System.out.println("\n --- LISTA DE CONTAS ---");
                    contaController.listarConta();
                    break;


                case 2:
                    System.out.print("Usuário: ");
                    String user = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    System.out.println("Animal (CACHORRO, GATO, PEIXE, AVES, OUTRO): ");
                    String animalStr = sc.nextLine();
                    Animal animal = Animal.valueOf(animalStr.toUpperCase());

                    contaController.criarConta(user, animal, senha);
                    break;

                case 3:
                    System.out.print("Digite o id da conta: ");
                    String idConta = sc.nextLine();
                    System.out.print("Digite o novo user: ");
                    String novoUser = sc.nextLine();
                    contaController.atualizarUser(idConta, novoUser);
                    break;

                case 4:
                    System.out.print("Digite o id da conta: ");
                    idConta = sc.nextLine();
                    contaController.deletarConta(idConta);
                    break;

                case 5:
                    System.out.print("ID da conta dona do post: ");
                    String contaId = sc.nextLine();

                    System.out.print("Legenda: ");
                    String legenda = sc.nextLine();

                    System.out.print("URL da imagem (ou vazio): ");
                    String imagem = sc.nextLine();
                    if (imagem.isBlank()) imagem = null;

                    Date data = new Date();

                    postController.criarPost(contaId, legenda, imagem, data);
                    break;

                case 6:
                    System.out.print("ID da conta: ");
                    contaId = sc.nextLine();
                    List<Post> posts = postController.listarPostsDaConta(contaId);
                    break;



                case 7:
                    System.out.print("ID do post: ");
                    String postId = sc.nextLine();

                    System.out.print("ID da conta: ");
                    contaId = sc.nextLine();

                    System.out.print("Nova legenda: ");
                    legenda = sc.nextLine();

                    System.out.print("Nova imagem (ou vazio): ");
                    imagem = sc.nextLine();
                    if (imagem.isBlank()) imagem = null;

                    Date dataAtualizada = new Date();

                    Post post = new Post(contaId, legenda, imagem, dataAtualizada);
                    post.setId(postId);

                    postController.atualizarPost(post);
                    break;

                case 8:
                    System.out.print("ID do post: ");
                    postId = sc.nextLine();

                    postController.deletarPost(postId);
                    break;


                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");


            }
        } while (opcao != 0);

        sc.close();
    }
}