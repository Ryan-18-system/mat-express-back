package br.edu.ifpb.model.services.impl;

import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.model.exception.ApplicationException;
import br.edu.ifpb.model.repositories.InstituicaoRepository;
import br.edu.ifpb.model.services.InstituicaoService;
import br.edu.ifpb.utils.UtilsDev;
import br.edu.ifpb.utils.mapers.impl.instituicao.InstituicaoMapperForm;
import br.edu.ifpb.utils.mapers.impl.instituicao.InstituicaoMapperView;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InstituicaoServiceImpl implements InstituicaoService {

    private final InstituicaoMapperForm instituicaoFormMapper;
    private final InstituicaoMapperView instituicaoViewMapper;
    private final InstituicaoRepository instituicaoRepository;

    @Inject
    public InstituicaoServiceImpl(InstituicaoMapperForm instituicaoFormMapper, InstituicaoMapperView instituicaoViewMapper, InstituicaoRepository instituicaoRepository) {
        this.instituicaoFormMapper = instituicaoFormMapper;
        this.instituicaoViewMapper = instituicaoViewMapper;
        this.instituicaoRepository = instituicaoRepository;
    }

    @Override
    @Transactional
    public void cadastrarInstituicao(InstituicaoForm form) throws ApplicationException {
        try{
            this.instituicaoRepository.persist(this.instituicaoFormMapper.map(form));
        }catch (Exception e){
            throw new ApplicationException("ERRO.CADASTRO.INSTITUICAO",401);

        }
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
