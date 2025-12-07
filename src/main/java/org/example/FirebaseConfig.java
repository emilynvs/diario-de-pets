package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;

public class FirebaseConfig {
    public void initialize() {
        try{

            FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://projeto-firebase-bd2-default-rtdb.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
