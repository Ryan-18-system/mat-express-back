package br.edu.ifpb.model.repositories;

import br.edu.ifpb.model.entities.Instituicao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstituicaoRepository implements PanacheRepository<Instituicao> {
}
