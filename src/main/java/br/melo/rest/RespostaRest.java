package br.melo.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.melo.dto.RespostaDto;
import br.melo.exception.EscolaException;
import br.melo.service.RespostaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("resposta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RespostaRest {

    @Inject
    RespostaService service;

    @GET
    @Operation(summary = "Listar respostas.",
            description = "Listar respostas: prova, aluno, nota e solução.")
    @APIResponse(responseCode = "200",
            description = "resposta",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = RespostaDto.class))
            }
    )
    public Response listar() {
        return Response.status(Status.OK).entity(service.listar()).build();
    }
    
    
    @POST
	@Path("")
	@Operation(summary = "Cadastrar resposta do aluno: id da prova, matrícula do aluno e solução.",
	description = "Modelo da solução: '1a, 2B, 3e'.")
	@APIResponse(responseCode = "201",
	description = "resposta",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = RespostaDto.class))
			}
	)
	public Response cadastrar(RespostaDto respostaDto) {
		try {
			service.cadastrar(respostaDto);
			return Response.status(Status.CREATED).build();
		} catch (EscolaException e) {
			return Response.status(Status.BAD_REQUEST).entity(e).build();
		}
	}
    
    
}