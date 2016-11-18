package slu.model;

import java.util.HashSet;
import java.util.Set;

public class Universidades implements java.io.Serializable {

    private int id;
    private Contato contato;
    private String nome;
    private String sigla;
    private String cnpj;
    private String orgAcademica;
    private String rede;
    private String catAdmin;
    private String mantenedora;
    private String site;
    private String procurador;
    private String cpfProcurador;
    private Set usuarios = new HashSet(0);

    public Universidades() {
    }

    public Universidades(int id, String nome, String sigla, String cnpj, String orgAcademica, String rede, String catAdmin) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.cnpj = cnpj;
        this.orgAcademica = orgAcademica;
        this.rede = rede;
        this.catAdmin = catAdmin;
    }

    public Universidades(int id, Contato contato, String nome, String sigla, String cnpj, String orgAcademica, String rede, String catAdmin, String mantenedora, String site, String procurador, String cpfProcurador, Set usuarios) {
        this.id = id;
        this.contato = contato;
        this.nome = nome;
        this.sigla = sigla;
        this.cnpj = cnpj;
        this.orgAcademica = orgAcademica;
        this.rede = rede;
        this.catAdmin = catAdmin;
        this.mantenedora = mantenedora;
        this.site = site;
        this.procurador = procurador;
        this.cpfProcurador = cpfProcurador;
        this.usuarios = usuarios;
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
        if (nome != null && nome.length() > 0) {
            this.nome = nome;
        }
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null && sigla.length() > 0) {
            this.sigla = sigla;
        }
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        if (cnpj != null && cnpj.length() > 0) {
            this.cnpj = cnpj;
        }
    }

    public String getOrgAcademica() {
        return this.orgAcademica;
    }

    public void setOrgAcademica(String orgAcademica) {
        if (orgAcademica != null && orgAcademica.length() > 0) {
            this.orgAcademica = orgAcademica;
        }
    }

    public String getRede() {
        return this.rede;
    }

    public void setRede(String rede) {
        if (rede != null && rede.length() > 0) {
            this.rede = rede;
        }
    }

    public String getCatAdmin() {
        return this.catAdmin;
    }

    public void setCatAdmin(String catAdmin) {
        if (catAdmin != null && catAdmin.length() > 0) {
            this.catAdmin = catAdmin;
        }
    }

    public String getMantenedora() {
        return this.mantenedora;
    }

    public void setMantenedora(String mantenedora) {
        if (mantenedora != null && mantenedora.length() > 0) {
            this.mantenedora = mantenedora;
        }
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        if (site != null && site.length() > 0) {
            this.site = site;
        }
    }

    public String getProcurador() {
        return this.procurador;
    }

    public void setProcurador(String procurador) {
        if (procurador != null && procurador.length() > 0) {
            this.procurador = procurador;
        }
    }

    public String getCpfProcurador() {
        return this.cpfProcurador;
    }

    public void setCpfProcurador(String cpfProcurador) {
        if (cpfProcurador != null && cpfProcurador.length() > 0) {
            this.cpfProcurador = cpfProcurador;
        }
    }

    public Set getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

}
