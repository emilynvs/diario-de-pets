package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreConfig {

    private static Firestore db;

    public static Firestore initialize() {
        if (db != null) return db;

        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Firestore inicializado com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return db;
    }
}
