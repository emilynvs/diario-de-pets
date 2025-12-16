package org.example.controller;

import org.example.model.entity.Conta;
import org.example.model.enuns.Animal;
import org.example.model.service.ContaService;
import org.example.model.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class ContaController {

    private ContaService contaService = new ContaService();
    private PostService postService = new PostService();
    public void criarConta(String user, Animal animal, String senha){
        Conta conta = new Conta(user, animal, senha);
        contaService.criarConta(conta);
        System.out.println("Conta criada!");
    }

    public void listarConta(){
        List<Conta> contas = new ArrayList<>();
        if(contas.isEmpty()) {
            contas = contaService.listarConta();
            for (Conta c : contas) {
                System.out.println(c);
            }
        }
    }

    public void atualizarUser(String idConta, String novoUser){
        if (contaService.atualizarUser(idConta, novoUser)) {
            System.out.println("Usuário atualizado!");
        } else {
            System.out.println("Conta não encontrada!");
        }

    }

    public void deletarConta(String idConta){
        if (contaService.deletarConta(idConta)) {
            postService.deletarPostsDaConta(idConta);
            System.out.println("Conta deletada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }

    }
}
