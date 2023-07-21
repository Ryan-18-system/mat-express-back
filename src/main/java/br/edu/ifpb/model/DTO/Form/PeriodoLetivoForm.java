package br.edu.ifpb.model.DTO.Form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

public class PeriodoLetivoForm {
    @Range(min = 1, max = 2)
    private Integer semestre;
    @NotNull
    private Long codInstituicao;
    @JsonDeserialize
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
    private Date dataInicio;
    @JsonDeserialize
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
    private Date dataFim;

    @NotNull
    private boolean indAtual;

    public boolean getIndAtual() {
        return indAtual;
    }

    public void setIndAtual(boolean indAtual) {
        this.indAtual = indAtual;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Long getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(Long codInstituicao) {
        this.codInstituicao = codInstituicao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodoLetivoForm that = (PeriodoLetivoForm) o;

        if (semestre != null ? !semestre.equals(that.semestre) : that.semestre != null) return false;
        if (codInstituicao != null ? !codInstituicao.equals(that.codInstituicao) : that.codInstituicao != null)
            return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semestre != null ? semestre.hashCode() : 0;
        result = 31 * result + (codInstituicao != null ? codInstituicao.hashCode() : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        return result;
    }
}
