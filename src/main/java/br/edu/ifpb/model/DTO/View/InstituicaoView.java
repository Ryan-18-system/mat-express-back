package br.edu.ifpb.model.DTO.View;

import jakarta.persistence.Column;

public class InstituicaoView {

    private Long codInstituicao;

    private String nome;

    private String sigla;

    private String contato;

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
}
