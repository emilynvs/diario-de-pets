package org.example.model.entity;

import org.example.model.enuns.Animal;

public  class  Conta {
    private int id;
    private String user;
    private Animal animal;
    private String senha;


    public Conta(String user, Animal animal, String senha) {
        this.id = id;
        this.user = user;
        this.animal = animal;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
