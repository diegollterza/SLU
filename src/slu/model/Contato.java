package slu.model;

import java.util.HashSet;
import java.util.Set;

public class Contato implements java.io.Serializable {

    private int id;
    private String cep;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String email;
    private Set usuarios = new HashSet(0);
    private Set universidadeses = new HashSet(0);

    public Contato() {
    }

    public Contato(int id) {
        this.id = id;
    }

    public Contato(int id, String cep, String endereco, Integer numero, String complemento, String bairro, String cidade, String uf, String telefone, String email, Set usuarios, Set universidadeses) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
        this.usuarios = usuarios;
        this.universidadeses = universidadeses;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        if (cep != null && cep.length() > 0) {
            this.cep = cep;
        }
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco != null && endereco.length() > 0) {
            this.endereco = endereco;
        }
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        if (numero != null) {
            this.numero = numero;
        }
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento != null && complemento.length() > 0) {
            this.complemento = complemento;
        }
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        if (bairro != null && bairro.length() > 0) {
            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        if (cidade != null && cidade.length() > 0) {
            this.cidade = cidade;
        }
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        if (uf != null && uf.length() > 0) {
            this.uf = uf;
        }
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && telefone.length() > 0) {
            this.telefone = telefone;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email != null && email.length() > 0) {
            this.email = email;
        }
    }

    public Set getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

    public Set getUniversidadeses() {
        return this.universidadeses;
    }

    public void setUniversidadeses(Set universidadeses) {
        this.universidadeses = universidadeses;
    }

}
