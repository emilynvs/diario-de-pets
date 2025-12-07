package org.example.model.service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.example.model.entity.Conta;

import java.util.concurrent.CountDownLatch;

public class ContaService {


    public void criarConta(Conta conta){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Conta").push();
        CountDownLatch latch = new CountDownLatch(1);
        ref.setValueAsync(conta).addListener(() -> {
            latch.countDown();
        }, Runnable::run);

        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void deletarConta(int idConta){
    }

    public void atualizarUser(int idConta){}

    public Conta listarConta(){
        return null;
    }

    public void atualizarSenha(){}



//    public void seguirConta(int id) {
//    }
//
//    public void deixarDeSeguir(int id) {
//    }
//
//    public void postar() {
//    }
//
//    public void apagarPostagem(int id){}
//
//    public void comentar(int idPostagem){}
//
//    public void apagarComentario(int idComentario){}
//
//    public void curtir(int idPostagem){}
//
//    public void apagarCurtida(int idPostagem){}


}
