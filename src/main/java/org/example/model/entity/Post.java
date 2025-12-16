package org.example.model.entity;


import java.util.Date;

public class Post {

    private String id;
    private String contaId;
    private String legendaPost;
    private String imagemPost;
    private Date dataDePublicacao;

    public Post() {
    }

    public Post(String contaId, String legendaPost, String imagemPost, Date dataDePublicacao) {
        this.contaId = contaId;
        this.legendaPost = legendaPost;
        this.imagemPost = imagemPost;
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContaId() {
        return contaId;
    }

    public void setContaId(String contaId) {
        this.contaId = contaId;
    }

    public String getLegendaPost() {
        return legendaPost;
    }

    public void setLegendaPost(String legendaPost) {
        this.legendaPost = legendaPost;
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

    @Override
    public String toString() {
        return "Post{" +
                "id= " + id +
                ", \ncontaId= " + contaId +
                ", \nlegendaPost= " + legendaPost +
                ", \nimagemPost= " + imagemPost +
                ", \ndataDePublicacao=" + dataDePublicacao +
                "}\n";
    }
}
