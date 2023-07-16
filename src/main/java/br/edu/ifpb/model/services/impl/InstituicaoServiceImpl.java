package br.edu.ifpb.model.services.impl;

import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.model.exception.ApplicationException;
import br.edu.ifpb.model.repositories.InstituicaoRepository;
import br.edu.ifpb.model.services.InstituicaoService;
import br.edu.ifpb.utils.UtilsDev;
import br.edu.ifpb.utils.mapers.impl.InstituicaoFormImpl;
import br.edu.ifpb.utils.mapers.impl.InstituicaoViewImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class InstituicaoServiceImpl implements InstituicaoService {

    private final InstituicaoFormImpl instituicaoFormMapper;
    private final InstituicaoViewImpl instituicaoViewMapper;
    private final InstituicaoRepository instituicaoRepository;

    @Inject
    public InstituicaoServiceImpl(InstituicaoFormImpl instituicaoFormMapper, InstituicaoViewImpl instituicaoViewMapper, InstituicaoRepository instituicaoRepository) {
        this.instituicaoFormMapper = instituicaoFormMapper;
        this.instituicaoViewMapper = instituicaoViewMapper;
        this.instituicaoRepository = instituicaoRepository;
    }

    @Override
    @Transactional
    public void cadastrarInstituicao(InstituicaoForm form) throws ApplicationException {
        this.instituicaoRepository.persist(this.instituicaoFormMapper.map(form));
    }

    @Override
    public InstituicaoView pesquisarPorCodInstituicao(Long codInstituicao) throws ApplicationException{
        Instituicao instituicaoBanco = this.instituicaoRepository.findById(codInstituicao);
        if(UtilsDev.ehNullOuVazio(instituicaoBanco)){
            throw new ApplicationException("ERRO.AO.PESQUISAR.INSTITUICAO", 401);
        }
        return  this.instituicaoViewMapper.map(instituicaoBanco);
    }
}
