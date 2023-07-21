package br.edu.ifpb.utils.mapers.impl.periodo;

import br.edu.ifpb.model.DTO.Form.PeriodoLetivoForm;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.model.entities.PeriodoLetivo;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.RequestScoped;

import java.util.Collection;

@RequestScoped
public class PeriodoLetivoMapperForm implements Mapper<PeriodoLetivoForm, PeriodoLetivo> {

    @Override
    public PeriodoLetivo map(PeriodoLetivoForm object) {
        PeriodoLetivo novoPeriodo = new PeriodoLetivo();
        novoPeriodo.setCodInstituicao(new Instituicao(object.getCodInstituicao()));
        novoPeriodo.setDataFim(object.getDataFim());
        novoPeriodo.setDataInicio(object.getDataFim());
        novoPeriodo.setSemestre(object.getSemestre());
        novoPeriodo.setIndAtual(object.getIndAtual());
        return novoPeriodo;
    }

    @Override
    public Collection<PeriodoLetivo> mapCollection(Collection<PeriodoLetivoForm> objects) {
        return null;
    }
}
