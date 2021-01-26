package br.melo.exception;

import java.io.Serializable;

public class EscolaException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    public EscolaException() {
        super();
    }
    public EscolaException(String msg)   {
        super(msg);
    }
    public EscolaException(String msg, Exception e)  {
        super(msg, e);
    }
    
    
}