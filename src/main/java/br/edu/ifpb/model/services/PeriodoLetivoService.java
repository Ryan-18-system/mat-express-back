package br.edu.ifpb.model.services;

import br.edu.ifpb.model.DTO.Form.PeriodoLetivoForm;
import br.edu.ifpb.model.DTO.View.PeriodoLetivoView;
import br.edu.ifpb.model.exception.ApplicationException;

import java.util.Collection;

public interface PeriodoLetivoService {
    void cadastrarPeriodoLetivo(PeriodoLetivoForm dto)throws ApplicationException;

    Collection<PeriodoLetivoView> listarPeriodosLetivos()throws ApplicationException;

}
