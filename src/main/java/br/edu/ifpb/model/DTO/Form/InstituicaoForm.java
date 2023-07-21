package br.edu.ifpb.model.DTO.Form;


import jakarta.validation.constraints.NotBlank;

public class InstituicaoForm {
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    private String nome;
    @NotBlank(message = "Sigla não pode ser nula ou vazia")
    private String sigla;
    @NotBlank(message = "Contato não pode ser nulo ou vazio")
    private String contato;
    private Long codPeriodoAtual;

    public Long getCodPeriodoAtual() {
        return codPeriodoAtual;
    }

    public void setCodPeriodoAtual(Long codPeriodoAtual) {
        this.codPeriodoAtual = codPeriodoAtual;
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
