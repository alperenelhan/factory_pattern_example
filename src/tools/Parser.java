/*
 * @(#)Parser.java   12/05/13
 * 
 * Copyright (c) 2005 your company name
 *
 * License agreement text here ...
 *
 *
 *
 */



package tools;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

/**
 *
 * @author oae
 */
public class Parser {

    /**
     * Constructs Parser class
     *
     */
    public Parser () {}

    /**
     * Parses the given line return variables as InputObject.
     *
     *
     *
     * @param line line to be parsed
     * @return input variables as in InputObject
     *
     * @throws Exception
     */
    public InputObject parse ( String line ) throws Exception {

        String[]    arr = line.trim ().split ( "," );
        InputObject inpObj;

        if ( arr.length != 6 ) throw new IOException ( "Incorrect input format" );
        inpObj = new InputObject ( Integer.parseInt ( arr[0].trim () ), Integer.parseInt ( arr[1].trim () ),
                                   Integer.parseInt ( arr[2].trim () ), Integer.parseInt ( arr[3].trim () ),
                                   Integer.parseInt ( arr[4].trim () ), arr[5].trim ().toUpperCase () );

        return inpObj;
    }
}
