package br.edu.ifpb.model.services.impl;

import br.edu.ifpb.model.DTO.Form.PeriodoLetivoForm;
import br.edu.ifpb.model.DTO.View.PeriodoLetivoView;
import br.edu.ifpb.model.exception.ApplicationException;
import br.edu.ifpb.model.repositories.PeriodoLetivoRepository;
import br.edu.ifpb.model.services.PeriodoLetivoService;
import br.edu.ifpb.utils.mapers.impl.periodo.PeriodoLetivoMapperForm;
import br.edu.ifpb.utils.mapers.impl.periodo.PeriodoLetivoMapperView;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Collection;
@ApplicationScoped
public class PeriodoLetivoImpl implements PeriodoLetivoService {

    private final PeriodoLetivoRepository periodoLetivoRepository;
    private  final PeriodoLetivoMapperForm mapperForm;
    private final PeriodoLetivoMapperView mapperView;

    @Inject
    public PeriodoLetivoImpl(PeriodoLetivoRepository periodoLetivoRepository, PeriodoLetivoMapperForm mapperForm, PeriodoLetivoMapperView mapperView) {
        this.periodoLetivoRepository = periodoLetivoRepository;
        this.mapperForm = mapperForm;
        this.mapperView = mapperView;
    }

    @Override
    @Transactional
    public void cadastrarPeriodoLetivo(PeriodoLetivoForm dto) throws ApplicationException {
        try {
            this.periodoLetivoRepository.persist(mapperForm.map(dto));
        }catch (Exception e){
            throw new ApplicationException("ERRO.CADASTRO.PERIODO.LETIVO",401);
        }
    }

    @Override
    public Collection<PeriodoLetivoView> listarPeriodosLetivos() throws ApplicationException {
        try{
            return this.mapperView.mapCollection(this.periodoLetivoRepository.listAll());

        }catch (Exception e){
            throw  new ApplicationException("ERRO.LISTAGEM.PERIODO.LETIVO",41);
        }
    }
}
