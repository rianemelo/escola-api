package br.melo.rest;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.melo.dto.AlunoDto;
import br.melo.exception.EscolaException;
import br.melo.model.Aluno;
import br.melo.service.AlunoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoRest {

	@Inject
	AlunoService service;

	@GET
	@Operation(summary = "Listar alunos.",
	description = "Listar alunos.")
	@APIResponse(responseCode = "200",
	description = "aluno",
	content = {
			@Content(mediaType =  "application/json",
					schema = @Schema(implementation = Aluno.class))
		}
	)
	public Response listar() {
		return Response.status(Status.OK).entity(service.listar()).build();
	}

	
	@GET
	@Path("{matricula}")
	@Operation(summary = "Verificar a nota final do aluno.",
	description = "Informe a matrícula do aluno.")
	@APIResponse(responseCode = "200",
	description = "aluno",
	content = {
			@Content(mediaType = "application/json",
					schema = @Schema(implementation = Aluno.class))
		}
	)
	public Response buscarAluno(@PathParam("matricula") String matricula) throws EscolaException {		
		try {
			Aluno aluno = service.buscarAluno(matricula);
			if ( aluno.getMedia() == -1F ) {
				throw new EscolaException("Aluno ainda não fez nenhuma prova!");
			}
			return Response.status(Status.OK).entity(aluno).build();
		} catch (EscolaException e) {
			return Response.status(Status.NOT_FOUND).entity(e).build();
		}
	}

	
	@GET
	@Path("aprovados")
	@Operation(summary = "Listar alunos aprovados.",
	description = "Listar alunos aprovados.")
	@APIResponse(responseCode = "200",
	description = "aluno",
	content = {
			@Content(mediaType =  "application/json",
					schema = @Schema(implementation = Aluno.class))
		}
	)
	public Response listarAprov() {
		return Response.status(Status.OK).entity(service.listarAprov()).build();
	}
	
	
	@POST
	@Path("")
	@Operation(summary = "Cadastrar aluno.",
	description = "Cadastrar aluno: matrícula e nome.")
	@APIResponse(responseCode = "201",
	description = "prova",
	content = {
			@Content(mediaType =  "application/json",
					schema = @Schema(implementation = AlunoDto.class))
			}
	)
	public Response cadastrar(AlunoDto alunoDto) {
		try {
			service.cadastrar(alunoDto);
			return Response.status(Status.CREATED).build();
		} catch (EscolaException e) {
			return Response.status(Status.METHOD_NOT_ALLOWED).entity(e).build();
		}
	}


}