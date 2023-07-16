package br.edu.ifpb.utils.mapers.impl;

import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstituicaoViewImpl implements Mapper<Instituicao, InstituicaoView> {
    @Override
    public InstituicaoView map(Instituicao object) {
        InstituicaoView instituicaoView = new InstituicaoView();
        instituicaoView.setContato(object.getContato());
        instituicaoView.setNome(object.getNome());
        instituicaoView.setSigla(object.getSigla());
        instituicaoView.setCodInstituicao(object.getCodInstituicao());
        return instituicaoView;
    }
}
