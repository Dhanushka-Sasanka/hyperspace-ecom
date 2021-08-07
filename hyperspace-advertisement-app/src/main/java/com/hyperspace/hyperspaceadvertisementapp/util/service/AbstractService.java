package com.hyperspace.hyperspaceadvertisementapp.util.service;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:12 PM
 **/

public abstract class AbstractService<T> {

    protected HttpHeaders addCommonHeaders( HttpHeaders responseHeaders )
    {
        responseHeaders.add( "Access-Control-Allow-Origin", "http://localhost:4200" );

        return responseHeaders;
    }

    protected ResponseEntity<T> buildNotFoundResponse()
    {
        return ResponseEntity.notFound().headers( new HttpHeaders() ).build();
    }

    protected ResponseEntity<ResponseWrapper<T>> buildNotFoundResponseWrapped()
    {
        return ResponseEntity.status( HttpStatus.NOT_FOUND )
                .headers( new HttpHeaders() )
                .body( new ResponseWrapper<>( SystemOperation.READ.withError(), SystemMessages.NOT_FOUND, "" ) );
    }

    protected ResponseEntity< ResponseWrapper<T> > buildExceptionErrorResponse( SystemOperation operation, SystemMessages message, Exception e )
    {
        Error error = ErrorUtility.exceptionErrorMapper( message, e, true );

        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR )
                .headers( new HttpHeaders() )
                .body( new ResponseWrapper<>( operation.withError(), message, error ) );


    }

    protected ResponseEntity<ResponseWrapper<Page<T>>> buildNotFoundResponseWrappedForPage()
    {
        return ResponseEntity.status( HttpStatus.NOT_FOUND )
                .headers( new HttpHeaders() )
                .body( new ResponseWrapper<>( SystemOperation.READ.withError(), SystemMessages.NOT_FOUND, "Not Entities Available Yet" ) );
    }

    protected ResponseEntity<ResponseWrapper< Page<T> >> buildPagedResponseWrapped( SystemOperation systemOperation, SystemMessages systemMessages, Page<T> page )
    {
        return ResponseEntity.status( HttpStatus.FOUND )
                .headers( new HttpHeaders() )
                .body( new ResponseWrapper<>( systemOperation, systemMessages, page ) );
    }

    protected ResponseEntity<ResponseWrapper <T> > buildResponseWrapped( SystemOperation systemOperation, SystemMessages systemMessages, T t )
    {
        return ResponseEntity.status( HttpStatus.CREATED )
                .headers( new HttpHeaders() )
                .body( new ResponseWrapper<>( systemOperation, systemMessages, t ) );
    }
}
