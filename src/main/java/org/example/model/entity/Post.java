package org.example.model.entity;

import com.google.cloud.Date;

public class Post {

    private String legendaPost;
    private int idPost;
    private String imagemPost;
    private Date dataDePublicacao;

    public Post() {
    }

    public Post(String legendaPost, int idPost, String imagemPost, Date dataDePublicacao) {
        this.legendaPost = legendaPost;
        this.idPost = idPost;
        this.imagemPost = imagemPost;
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getLegendaPost() {
        return legendaPost;
    }

    public void setLegendaPost(String legendaPost) {
        this.legendaPost = legendaPost;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getImagemPost() {
        return imagemPost;
    }

    public void setImagemPost(String imagemPost) {
        this.imagemPost = imagemPost;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }
}
