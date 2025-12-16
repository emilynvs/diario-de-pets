package org.example.model.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.example.config.FirestoreConfig;
import org.example.model.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PostService {

    private final Firestore db;

    public PostService() {
        this.db = FirestoreConfig.initialize();
    }

    public void criarPost(Post post) {
        try {
            DocumentReference ref = db.collection("posts").document();
            post.setId(ref.getId());
            ApiFuture<WriteResult> result = ref.set(post);
            System.out.println("Post criado em: " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPost(Post post) {
        try {
            DocumentReference ref = db.collection("posts").document(post.getId());
            ApiFuture<WriteResult> result = ref.set(post);
            System.out.println("Post atualizado em: " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void deletarPost(String postId) {
        try {
            ApiFuture<WriteResult> result = db.collection("posts").document(postId).delete();
            System.out.println("Post deletado em: " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void deletarPostsDaConta(String contaId) {
        try {
            var snapshot = db.collection("posts")
                    .whereEqualTo("contaId", contaId)
                    .get()
                    .get();

            var batch = db.batch();

            snapshot.getDocuments().forEach(doc ->
                    batch.delete(doc.getReference())
            );

            batch.commit().get();
            System.out.println("Posts da conta deletados.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Post> listarPostsDaConta(String contaId) {
        List<Post> posts = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("posts").whereEqualTo("contaId", contaId).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot doc : documents) {
                Post p = doc.toObject(Post.class);
                p.setId(doc.getId());
                posts.add(p);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
