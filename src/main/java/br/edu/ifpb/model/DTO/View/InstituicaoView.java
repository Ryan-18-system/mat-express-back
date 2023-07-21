package br.edu.ifpb.model.DTO.View;

import jakarta.persistence.Column;

import java.util.HashSet;
import java.util.Set;

public class InstituicaoView {

    private Long codInstituicao;

    private String nome;

    private String sigla;

    private String contato;

    private Set<PeriodoLetivoView> periodosLetivos = new HashSet<>();

    public Set<PeriodoLetivoView> getPeriodosLetivos() {
        return periodosLetivos;
    }

    public void setPeriodosLetivos(Set<PeriodoLetivoView> periodosLetivos) {
        this.periodosLetivos = periodosLetivos;
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
}
