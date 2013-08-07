/*
 * @(#)Rinsing.java   12/05/13
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
public class Rinsing extends Process {

    /**
     * Constructs Rinsing class extended from Process
     *
     *
     * @param time how much time that process works
     * @param heat needed water degree to work
     * @param inpObj holds the given input variables from input file
     */
    public Rinsing ( int time, int heat, InputObject inpObj ) {

        setHeat ( heat );
        setNeededWater ( inpObj.getKg () * 5 );
        setRevolution ( 200 );
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
        return "rinsing";
    }
}
