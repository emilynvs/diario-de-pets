package org.example.model.service;

import com.google.firebase.database.*;
import org.example.model.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
//Estou em desenvolvimento em listar post, está dando alguns erros na hora de listar e irei resolver
public class PostService {

    public void criarPost(Post post) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post").push();
        post.setId(ref.getKey());
        ref.setValueAsync(post);
    }

//    public void listarPostsDaConta(String contaId, Consumer<List<Post>> callback) {
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post");

 //       ref.orderByChild("contaId").equalTo(contaId)
 //               .addListenerForSingleValueEvent(new ValueEventListener() {
  //                  @Override
  //                  public void onDataChange(DataSnapshot snapshot) {
 //                       List<Post> posts = new ArrayList<>();

 //                       for (DataSnapshot child : snapshot.getChildren()) {
  //                          Post post = child.getValue(Post.class);
  //                          posts.add(post);
  //                      }

 //                       callback.accept(posts);
 //                   }

  //                  @Override
   //                 public void onCancelled(DatabaseError error) {
  //                  }
  //              });
  //  }

//    public void listarTodos(Consumer<List<Post>> callback) {
//       DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post");

//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                List<Post> posts = new ArrayList<>();

//                for (DataSnapshot child : snapshot.getChildren()) {
//                    posts.add(child.getValue(Post.class));
//                }

//                callback.accept(posts);
//            }

//            @Override
//            public void onCancelled(DatabaseError error) {
//            }
//        });
//    }

    public void atualizarPost(Post post) {
        if (post.getId() == null) {
            throw new IllegalArgumentException("O post precisa ter um ID para ser atualizado.");
        }

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post").child(post.getId());
        ref.setValueAsync(post);
    }

    public void deletarPost(String postId) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Post").child(postId);
        ref.removeValueAsync();
    }
}
