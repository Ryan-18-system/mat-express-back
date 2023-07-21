package br.edu.ifpb.utils.mapers.impl.instituicao;

import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.RequestScoped;

import java.util.Collection;

@RequestScoped
public class InstituicaoMapperView implements Mapper<Instituicao, InstituicaoView> {
    @Override
    public InstituicaoView map(Instituicao object) {
        InstituicaoView instituicaoView = new InstituicaoView();
        instituicaoView.setContato(object.getContato());
        instituicaoView.setNome(object.getNome());
        instituicaoView.setSigla(object.getSigla());
        instituicaoView.setCodInstituicao(object.getCodInstituicao());
        return instituicaoView;
    }

    @Override
    public Collection<InstituicaoView> mapCollection(Collection<Instituicao> objects) {
        return null;
    }
}
