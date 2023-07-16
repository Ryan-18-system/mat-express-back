package br.edu.ifpb.resources;

import br.edu.ifpb.model.DTO.EntityErrorDTO;
import br.edu.ifpb.model.DTO.Form.InstituicaoForm;
import br.edu.ifpb.model.DTO.View.InstituicaoView;
import br.edu.ifpb.model.services.InstituicaoService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;


@Path("/instituicao")
@Produces(MediaType.APPLICATION_JSON)
public class InstituicaoResource {

    private final InstituicaoService instituicaoService;
    private final Validator validator;
    @Inject
    public InstituicaoResource(InstituicaoService instituicaoService, Validator validator) {

        this.instituicaoService = instituicaoService;
        this.validator = validator;
    }

    @POST
    public Response cadastrarInstituicao(InstituicaoForm form){

        Set<ConstraintViolation<InstituicaoForm>> violationSet = validator.validate(form);
        if (!violationSet.isEmpty()) {
            return EntityErrorDTO.createFromValidation(violationSet)
                    .withStatusCode(EntityErrorDTO.UNPROCESSABLE_ENTITY_STATUS);
        }
        try {
            this.instituicaoService.cadastrarInstituicao(form);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            return EntityErrorDTO
                    .createFromException(e.getMessage())
                    .withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
        }
    }

    @GET
    @Path("/{codInstituicao}")
    public Response pesquisarInstituicaoPorCod(@PathParam("codInstituicao") Long codInstituicao) {
        try {
            InstituicaoView instituicaoView = this.instituicaoService.pesquisarPorCodInstituicao(codInstituicao);
            return Response.ok(instituicaoView).build();
        }catch (Exception e){
            return EntityErrorDTO
                    .createFromException(e.getMessage())
                    .withStatusCode(Response.Status.NOT_FOUND.getStatusCode());
        }

    }
}
