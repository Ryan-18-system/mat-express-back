package br.edu.ifpb.model.DTO.View;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class PeriodoLetivoView {

    private Long codPeriodoLetivo;
    private Integer semestre;
    @JsonDeserialize
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
    private Date dataInicio;
    @JsonDeserialize
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
    private Date dataFim;

    private Long codInstituicao;

    public Long getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(Long codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    private boolean indAtual;

    public boolean isIndAtual() {
        return indAtual;
    }

    public void setIndAtual(boolean indAtual) {
        this.indAtual = indAtual;
    }

    public Long getCodPeriodoLetivo() {
        return codPeriodoLetivo;
    }

    public void setCodPeriodoLetivo(Long codPeriodoLetivo) {
        this.codPeriodoLetivo = codPeriodoLetivo;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
