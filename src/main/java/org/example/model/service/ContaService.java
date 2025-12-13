package org.example.model.service;

import com.google.api.core.ApiFuture;
import com.google.firebase.database.*;
import org.example.model.entity.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class ContaService {


    public void criarConta(Conta conta){
        CountDownLatch latch = new CountDownLatch(1);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Conta").push();
        String idGerado = ref.getKey();
        conta.setId(idGerado);

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

    public void atualizarUser(String idConta, String novoUser){
        CountDownLatch latch = new CountDownLatch(1);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Conta").child(idConta);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    latch.countDown();
                    return;
                }

                Conta antiga = dataSnapshot.getValue(Conta.class);
                DatabaseReference versao = ref.child("versao").push();
                antiga.setTimestamp(System.currentTimeMillis());
                versao.setValueAsync(antiga);

                Map<String, Object> atualizar = new HashMap<>();
                atualizar.put("user", novoUser);

                ApiFuture<Void> future = ref.updateChildrenAsync(atualizar);

                latch.countDown();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Erro ao atualizar: "+ databaseError.getMessage());
                latch.countDown();
            }
        });
        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listarConta() {
        CountDownLatch latch = new CountDownLatch(1);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Conta");
        List<Conta> contas = new ArrayList<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        Conta conta = child.getValue(Conta.class);
                        conta.setId(child.getKey());
                        contas.add(conta);
                    }
                }
                latch.countDown();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Erro ao ler os dados: " + databaseError.getMessage());
                latch.countDown();
            }
        });

        try {
            latch.await(); // wait until onDataChange runs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return contas;
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
