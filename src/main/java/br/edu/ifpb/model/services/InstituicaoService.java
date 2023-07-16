package br.edu.ifpb.model.services;

import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.exception.ApplicationException;

public interface InstituicaoService {
    void cadastrarInstituicao(InstituicaoForm form) throws ApplicationException;
    InstituicaoView pesquisarPorCodInstituicao(Long codInstituicao) throws ApplicationException;

}
