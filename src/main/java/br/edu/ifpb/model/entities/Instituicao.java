package br.edu.ifpb.model.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_instituicao", schema = "mat_express")
public class Instituicao  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_instituicao")
    private Long codInstituicao;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "contato")
    private String contato;
    @Column(name = "st_situacao")
    private Integer stSituacao;

    @PrePersist
    public void situacaoInicial() {
        this.stSituacao = 1;
    }

    public Instituicao() {
    }

    public Instituicao(Long codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    public Long getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(Long codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Integer getStSituacao() {
        return stSituacao;
    }

    public void setStSituacao(Integer stSituacao) {
        this.stSituacao = stSituacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instituicao that = (Instituicao) o;

        if (codInstituicao != null ? !codInstituicao.equals(that.codInstituicao) : that.codInstituicao != null)
            return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sigla != null ? !sigla.equals(that.sigla) : that.sigla != null) return false;
        if (contato != null ? !contato.equals(that.contato) : that.contato != null) return false;
        if (stSituacao != null ? !stSituacao.equals(that.stSituacao) : that.stSituacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codInstituicao != null ? codInstituicao.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sigla != null ? sigla.hashCode() : 0);
        result = 31 * result + (contato != null ? contato.hashCode() : 0);
        result = 31 * result + (stSituacao != null ? stSituacao.hashCode() : 0);
        return result;
    }
}
