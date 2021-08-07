package com.hyperspace.hyperspaceadvertisementapp.util.service;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  8:34 PM
 **/

public enum SystemOperation {

    READ,
    CREATE,
    MODIFY,
    DELETE;

    private boolean status = false;

    public SystemOperation withError()
    {
        this.status = false;
        return this;
    }

    public SystemOperation withSuccess()
    {
        this.status = true;
        return this;
    }

    public boolean status()
    {
        return this.status;
    }
}
