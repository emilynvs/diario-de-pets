package org.example.model.entity;

import org.example.model.enuns.Animal;

public  class  Conta {
    private String id;
    private String user;
    private String animal;
    private String senha;

    public Conta(){}

    public Conta(String user, Animal animal, String senha) {
        this.user = user;
        this.animal = animal.name();
        this.senha = senha;

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return Animal.valueOf(this.animal);    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", animal=" + animal +
                ", senha='" + senha + '\'' +
                '}';
    }
}
