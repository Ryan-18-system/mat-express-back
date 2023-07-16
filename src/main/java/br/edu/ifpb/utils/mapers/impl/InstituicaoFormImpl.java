package br.edu.ifpb.utils.mapers.impl;

import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.entities.Instituicao;
import br.edu.ifpb.utils.mapers.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.Locale;

@ApplicationScoped
public class InstituicaoFormImpl implements Mapper<InstituicaoForm, Instituicao> {
    @Override
    public Instituicao map(InstituicaoForm object) {
        Instituicao novaIntituicao = new Instituicao();
        novaIntituicao.setNome(object.getNome());
        novaIntituicao.setContato(object.getContato());
        novaIntituicao.setSigla(object.getSigla().toUpperCase(Locale.ROOT));
        return novaIntituicao;
    }
}
