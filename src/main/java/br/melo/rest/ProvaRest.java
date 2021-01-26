package br.melo.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.melo.dto.ProvaDto;
import br.melo.exception.EscolaException;
import br.melo.model.Prova;
import br.melo.service.ProvaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("prova")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProvaRest {

    @Inject
    ProvaService service;

    @GET
    @Operation(summary = "Listar provas.",
            description = "Listar provas.")
    @APIResponse(responseCode = "200",
            description = "prova",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = Prova.class))
            }
    )
    public Response listar(){
        return Response.status(Status.OK).entity(service.listar()).build();
    }
    
    
    @POST
	@Path("")
	@Operation(summary = "Cadastrar prova: gabarito e peso de cada questão.",
	description = "Modelo: gabarito '1a, 2B, 3e' , peso '3, 3, 4'.")
	@APIResponse(responseCode = "201",
	description = "prova",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ProvaDto.class))
			}
	)
	public Response cadastrar(ProvaDto provaDto) {
		try {
			service.cadastrar(provaDto);
			return Response.status(Status.CREATED).build();
		} catch (EscolaException e) {
			return Response.status(Status.BAD_REQUEST).entity(e).build();
		}
	}
    
    
}