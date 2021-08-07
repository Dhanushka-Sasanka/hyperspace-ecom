package com.hyperspace.hyperspaceadvertisementapp.util.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Common Error Wrapper
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:29 PM
 **/

@Data
public class Error {

    private String code;
    private String message;
    private List<String> errorList;

    public void addMessage( String message )
    {
        if( this.errorList == null )
        {
            this.errorList = new ArrayList<>();
        }

        this.errorList.add( message );
    }


}
