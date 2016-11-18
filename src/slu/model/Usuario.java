package slu.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Usuario implements java.io.Serializable {

    private int id;
    private Contato contato;
    private String nome;
    private String senha;
    private Set universidadeses = new HashSet(0);

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int id, Contato contato, String nome, String senha, Set universidadeses) {
        this.id = id;
        this.contato = contato;
        this.nome = nome;
        this.senha = senha;
        this.universidadeses = universidadeses;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set getUniversidadeses() {
        return this.universidadeses;
    }

    public void setUniversidadeses(Set universidadeses) {
        this.universidadeses = universidadeses;
    }
}
