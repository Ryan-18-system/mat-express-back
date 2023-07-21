package br.edu.ifpb.model.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "tb_periodo_letivo",schema = "mat_express")
public class PeriodoLetivo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpd_periodo_letivo")
    private Long codPeriodoLetivo;
    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "data_inicio")
    private Date dataInicio;
    @Column(name = "data_fim")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "cod_instituicao", referencedColumnName = "cod_instituicao")
    private Instituicao codInstituicao;
    @Column(name = "periodo_atual")
    private boolean indAtual;
     @Column(name = "st_situacao")
    private Integer stSituacao;

    @PrePersist
    public void situacaoInicial() {
        this.stSituacao = 1;
    }

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

    public Instituicao getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(Instituicao codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    public Integer getStSituacao() {
        return stSituacao;
    }

    public void setStSituacao(Integer stSituacao) {
        this.stSituacao = stSituacao;
    }
}
