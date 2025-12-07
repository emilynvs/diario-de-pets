package org.example.controller;

import org.example.model.entity.Conta;
import org.example.model.enuns.Animal;
import org.example.model.service.ContaService;

public class ContaController {

    private ContaService contaService = new ContaService();

    public void criarConta(String user, Animal animal, String senha){
        Conta conta = new Conta(user, animal, senha);
        contaService.criarConta(conta);
        System.out.println("Conta criada!");
    }
}
