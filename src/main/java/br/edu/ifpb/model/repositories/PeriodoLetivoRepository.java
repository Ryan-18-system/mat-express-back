package br.edu.ifpb.model.repositories;


import br.edu.ifpb.model.entities.PeriodoLetivo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PeriodoLetivoRepository implements PanacheRepository<PeriodoLetivo> {
}
