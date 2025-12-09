package org.example;

import com.google.firebase.database.*;
import org.example.controller.ContaController;
import org.example.model.enuns.Animal;

import java.util.Scanner;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirebaseConfig firebaseConfig = new FirebaseConfig();
        firebaseConfig.initialize();
        Scanner sc = new Scanner(System.in);
        ContaController controller = new ContaController();

        // Criando conta

      /*controller.criarConta("Naba", Animal.AVES, "Admin");
        controller.criarConta("SRA.Manteiga", Animal.CACHORRO, "admin");
        controller.criarConta("MeiaNoite", Animal.GATO, "admin");
        controller.criarConta("Sr. falante", Animal.AVES, "admin");*/
        controller.listarConta();
       // Thread.sleep(5000);

    }
}
