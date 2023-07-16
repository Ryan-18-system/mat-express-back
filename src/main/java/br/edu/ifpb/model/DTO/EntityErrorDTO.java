package br.edu.ifpb.model.DTO;

import br.edu.ifpb.utils.UtilsDev;
import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class EntityErrorDTO {

	public static final int UNPROCESSABLE_ENTITY_STATUS = 422;

    private String message;
    private Collection<EntityFieldErroDTO> erros;

    public EntityErrorDTO(String message, Collection<EntityFieldErroDTO> erros) {
        this.message = message;
        this.erros = erros;
    }//ResponseError

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<EntityFieldErroDTO> getErros() {
		return erros;
	}

	public void setErros(Collection<EntityFieldErroDTO> erros) {
		this.erros = erros;
	}

	public static int getUnprocessableEntityStatus() {
		return UNPROCESSABLE_ENTITY_STATUS;
	}

	public static <T> EntityErrorDTO createFromValidation(Set<ConstraintViolation<T>> violations) {
    	
        List<EntityFieldErroDTO> errors = violations
        		.stream()
        		.map(contVio -> new EntityFieldErroDTO(contVio.getPropertyPath().toString(), contVio.getMessage()))
        		.collect(Collectors.toList());
        
        String message = "";
        if(!UtilsDev.ehNullOuVazio(errors) && !errors.isEmpty()) {
        	message = errors.get(0).getMessage();
        }// if
        
        if(UtilsDev.ehNullOuVazio(message)) {
        	message = "Erro de Validação";
        }//if

        return new EntityErrorDTO(message, errors);
    }//ResponseError
	
	public static EntityErrorDTO createFromException(String message) {
    	
		EntityFieldErroDTO erro = new EntityFieldErroDTO("field", message);
        		
		Collection<EntityFieldErroDTO> errors = new ArrayList<>();
		errors.add(erro);

        return new EntityErrorDTO(message, errors);
    }//ResponseError

    public Response withStatusCode(int code){
        return Response.status(code).entity(this).build();
    }// withStatusCode
	
}// ErrorDTO
