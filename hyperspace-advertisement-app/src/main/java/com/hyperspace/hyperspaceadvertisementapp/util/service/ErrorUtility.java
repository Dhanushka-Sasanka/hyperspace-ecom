package com.hyperspace.hyperspaceadvertisementapp.util.service;

import javax.validation.ConstraintViolation;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:27 PM
 **/

public class ErrorUtility {

    private static final short CAUSED_BY_DEEP = 5;

    /**
     * Map Exception to system Error Object
     *
     * @param message       SystemMessages
     * @param e             Exception
     * @param matcherEnable exception matching required or not
     * @return Mapped Error Object
     */
    public static Error exceptionErrorMapper( SystemMessages message, Exception e, boolean matcherEnable )
    {
        Error error = new Error();
        error.setCode( message.getCode() );
        error.setMessage( message.getReasonPhrase() );

        if( e != null )
        {
            int level = 0;
            Throwable cause = e;

            while( cause != null && level < CAUSED_BY_DEEP )
            {
                if( matcherEnable )
                {
                    if( cause instanceof javax.validation.ConstraintViolationException )
                    {
                        Set<ConstraintViolation<?>> constraintViolations = ( (javax.validation.ConstraintViolationException) cause ).getConstraintViolations();
                        if( constraintViolations != null )
                        {
                            if( constraintViolations.stream().findFirst().isPresent() )
                            {
                                error.setMessage( "Constraint Violated[JV] : " + constraintViolations.stream().findFirst().get().getMessage() );
                            }
                        }
                    }
                    else if( cause instanceof org.hibernate.exception.ConstraintViolationException )
                    {
                        SQLException sqlException = ( (org.hibernate.exception.ConstraintViolationException) cause ).getSQLException();
                        String constraintName = ( (org.hibernate.exception.ConstraintViolationException) cause ).getConstraintName();

                        if( sqlException != null )
                        {
                            error.setMessage( "Constraint Violated[HB]-[" + constraintName + "]-" + sqlException.getMessage() );
                        }
                    }
                }

                error.addMessage( level + " - Caused By : " + cause.getMessage() );
                ++level;
                cause = cause.getCause();
            }
        }

        return error;
    }
}
