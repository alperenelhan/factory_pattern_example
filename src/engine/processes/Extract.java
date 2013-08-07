/*
 * @(#)Extract.java   12/05/13
 * 
 * Copyright (c) 2005 your company name
 *
 * License agreement text here ...
 *
 *
 *
 */



package engine.processes;

//~--- non-JDK imports --------------------------------------------------------

import engine.Process;

import tools.InputObject;

/**
 *
 * @author oae
 */
public class Extract extends Process {

    /**
     * Constructs Extract class extended from Process
     *
     *
     * @param time how much time that process works
     * @param inpObj holds the given input variables from input file
     */
    public Extract ( int time, InputObject inpObj ) {

        setNeededWater ( inpObj.getKg () * 0 );
        setRevolution ( 600 );
        setTime ( time );
        setInputVars ( inpObj );
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString () {
        return "extract";
    }
}
