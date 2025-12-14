package org.example.controller;

import org.example.model.entity.Post;
import org.example.model.service.PostService;

import java.time.LocalDate;
import java.util.List;
import com.google.cloud.Date;

public class PostController {

    private final PostService postService = new PostService();

    public void criarPost(String contaId, String legenda, String imagem, Date data) {
        Post post = new Post(contaId, legenda, imagem, data);
        postService.criarPost(post);
        System.out.println("Post criado com sucesso!");
    }

    public void atualizarPost(Post postAtualizado) {

        if (postAtualizado.getId() == null) {
            System.err.println("Erro: O post precisa ter ID para ser atualizado.");
            return;
        }

        postService.atualizarPost(postAtualizado);
        System.out.println("Post atualizado!");
    }

    public void deletarPost(String postId) {
        postService.deletarPost(postId);
        System.out.println("Post deletado!");
    }
}