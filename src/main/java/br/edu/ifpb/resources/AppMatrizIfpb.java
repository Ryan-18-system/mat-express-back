package br.edu.ifpb.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(title = "Sistema de matrícula de alunos e emissões de declarações",
                version = "1.0.0",
                description = "API para serviços do IFPB",
                contact = @Contact(
                        name = "Ryan Nóbrega (83)987466214",
                        url = ""
                )
        )
)
@ApplicationPath("/api")
public class AppMatrizIfpb extends Application {
}
