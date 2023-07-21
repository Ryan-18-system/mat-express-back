package br.edu.ifpb.utils.mapers.impl.instituicao;

import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.RequestScoped;

import java.util.Collection;
import java.util.Locale;

@RequestScoped
public class InstituicaoMapperForm implements Mapper<InstituicaoForm, Instituicao> {
    @Override
    public Instituicao map(InstituicaoForm object) {
        Instituicao novaIntituicao = new Instituicao();
        novaIntituicao.setNome(object.getNome());
        novaIntituicao.setContato(object.getContato());
        novaIntituicao.setSigla(object.getSigla().toUpperCase(Locale.ROOT));
        return novaIntituicao;
    }

    @Override
    public Collection<Instituicao> mapCollection(Collection<InstituicaoForm> objects) {
        return null;
    }
}
