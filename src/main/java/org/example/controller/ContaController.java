package org.example.controller;

import org.example.model.entity.Conta;
import org.example.model.enuns.Animal;
import org.example.model.service.ContaService;

import java.util.ArrayList;
import java.util.List;

public class ContaController {

    private ContaService contaService = new ContaService();

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
        System.out.println(contas.size());
    }

    public void atualizarUser(String idConta, String novoUser){
        contaService.atualizarUser(idConta, novoUser);
    }
}
