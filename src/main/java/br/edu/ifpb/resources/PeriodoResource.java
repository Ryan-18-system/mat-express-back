package br.edu.ifpb.resources;

import br.edu.ifpb.model.DTO.EntityErrorDTO;
import br.edu.ifpb.model.DTO.Form.PeriodoLetivoForm;
import br.edu.ifpb.model.DTO.View.PeriodoLetivoView;
import br.edu.ifpb.model.services.PeriodoLetivoService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;
import java.util.Set;

@Path("/periodo-letivo")
@Produces(MediaType.APPLICATION_JSON)
public class PeriodoResource {

    private final PeriodoLetivoService periodoLetivoSerive;
    private final Validator validator;

    @Inject
    public PeriodoResource(PeriodoLetivoService periodoLetivoSerive, Validator validator) {
        this.periodoLetivoSerive = periodoLetivoSerive;
        this.validator = validator;
    }

    @POST
    public Response cadastrarPeriodo(PeriodoLetivoForm form){

        Set<ConstraintViolation<PeriodoLetivoForm>> violationSet = validator.validate(form);
        if (!violationSet.isEmpty()) {
            return EntityErrorDTO.createFromValidation(violationSet)
                    .withStatusCode(EntityErrorDTO.UNPROCESSABLE_ENTITY_STATUS);
        }
        try {
            this.periodoLetivoSerive.cadastrarPeriodoLetivo(form);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            return EntityErrorDTO
                    .createFromException(e.getMessage())
                    .withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
        }
    }

    @GET
    public Response listarTodosPeriodos() {
        try {
            Collection<PeriodoLetivoView> periodoLetivoView = this.periodoLetivoSerive.listarPeriodosLetivos();
            return Response.ok(periodoLetivoView).build();
        }catch (Exception e){
            return EntityErrorDTO
                    .createFromException(e.getMessage())
                    .withStatusCode(Response.Status.NOT_FOUND.getStatusCode());
        }

    }
}
