package com.eprosima.idl.parser.exception;

import com.eprosima.log.ColorMessage;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class ParseException extends RecognitionException
{
	public ParseException()
    {
        super("", null, null, null);
    }
    
    public ParseException(Token token, String message)
    {
        super(message, null, null, null);

        if(token != null)
            setOffendingToken(token);
    }
}
