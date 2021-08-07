package com.hyperspace.hyperspaceadvertisementapp.util.service;

/**
 * Messages from each operations perform on system
 *
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  8:36 PM
 **/

public enum SystemMessages {

    NOT_FOUND( "100", "Requested data not found" ),
    BAD_REQUEST( "101", "Malformed Request" ),
    INVALID_DATA( "102", "Invalid data State" ),
    SUCCESSFULLY_LOADED( "103", "Data successfully loaded" ),

    USER_CREATE_SUCCESS( "1200", "User successfully saved" ),
    USER_CREATE_FAILED( "1201", "User saving failed" ),
    USER_UPDATE_SUCCESS( "1202", "User successfully updated" ),
    USER_UPDATE_FAILED( "1203", "User update failed" ),
    USER_DELETE_SUCCESS( "1204", "User successfully deleted" ),
    USER_DELETE_FAILED( "1205", "User delete failed" );

    private final String code;
    private final String reasonPhrase;


    SystemMessages( String code, String reasonPhrase )
    {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getReasonPhrase()
    {
        return this.reasonPhrase;
    }
}
