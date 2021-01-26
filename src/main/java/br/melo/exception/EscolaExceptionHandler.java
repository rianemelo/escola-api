package br.melo.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EscolaExceptionHandler implements ExceptionMapper<EscolaException> 
{
    @Override
    public Response toResponse(EscolaException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
    
    
}