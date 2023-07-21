package br.edu.ifpb.utils.mapers.impl.periodo;

import br.edu.ifpb.model.DTO.View.PeriodoLetivoView;
import br.edu.ifpb.model.entities.PeriodoLetivo;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.RequestScoped;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RequestScoped
public class PeriodoLetivoMapperView implements Mapper<PeriodoLetivo, PeriodoLetivoView> {
    @Override
    public PeriodoLetivoView map(PeriodoLetivo object) {
        PeriodoLetivoView periodoLetivoView = new PeriodoLetivoView();
        periodoLetivoView.setCodPeriodoLetivo(object.getCodPeriodoLetivo());
        periodoLetivoView.setDataFim(object.getDataFim());
        periodoLetivoView.setDataInicio(object.getDataInicio());
        periodoLetivoView.setCodInstituicao(object.getCodInstituicao().getCodInstituicao());
        periodoLetivoView.setSemestre(object.getSemestre());
        return  periodoLetivoView;
    }

    @Override
    public Collection<PeriodoLetivoView> mapCollection(Collection<PeriodoLetivo> objects) {
        List<PeriodoLetivoView> retorno = new ArrayList<>();
        for(PeriodoLetivo p: objects){
          retorno.add(this.map(p));
        }
        return retorno;
    }
}
