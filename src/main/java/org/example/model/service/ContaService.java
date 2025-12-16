package org.example.model.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.example.FirestoreConfig;
import org.example.model.entity.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ContaService {

    private final Firestore db;

    public ContaService() {
        this.db = FirestoreConfig.initialize();
    }

    public void criarConta(Conta conta) {
        try {
            DocumentReference ref = db.collection("contas").document();
            conta.setId(ref.getId());
            conta.setTimestamp(System.currentTimeMillis());
            ApiFuture<WriteResult> result = ref.set(conta);
            System.out.println("Conta criada em: " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void deletarConta(String idConta) {
        try {
            ApiFuture<WriteResult> writeResult = db.collection("contas").document(idConta).delete();
            System.out.println("Conta deletada em: " + writeResult.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void atualizarUser(String idConta, String novoUser) {
        try {
            DocumentReference docRef = db.collection("contas").document(idConta);
            ApiFuture<WriteResult> future = docRef.update("user", novoUser, "timestamp", System.currentTimeMillis());
            System.out.println("Conta atualizada em: " + future.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listarConta() {
        List<Conta> contas = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("contas").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot doc : documents) {
                Conta c = doc.toObject(Conta.class);
                c.setId(doc.getId());
                contas.add(c);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
