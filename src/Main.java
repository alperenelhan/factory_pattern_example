/*
 * @(#)Main.java   12/05/13
 * 
 * Copyright (c) 2005 your company name
 *
 * License agreement text here ...
 *
 *
 *
 */



//~--- non-JDK imports --------------------------------------------------------

import engine.Engine;

import tools.InputObject;
import tools.Parser;
import tools.Queue;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

/**
 * Main class. Everything starts from here :)
 *
 *
 * @version        Enter version here..., 12/05/09
 * @author         Osman Alperen Elhan
 */
public class Main {

    /**
     * @param args environmental arguments
     *
     * @throws IOException
     */
    public static void main ( String[] args ) throws IOException {

        if ( args.length < 2 ) {

            System.err.println ( "Not enough arguments!" );

            return;
        }

        // Local Variables
        Parser          parser = new Parser ();
        DataInputStream in     = new DataInputStream ( new FileInputStream ( args[0] ) );
        BufferedReader  br     = new BufferedReader ( new InputStreamReader ( in ) );
        String          line;
        InputObject     inpObj;
        Queue<Engine>   engineQueue = new Queue<Engine> ();

        /*
         * Read input and add to engine queue.
         * If exception is caught in parser class' parse method then don't add to queue.
         */
        while ( ( line = br.readLine () ) != null && ( line.trim ().length () != 0 ) ) {

            try {
                inpObj = parser.parse ( line );
            }
            catch ( Exception ex ) {
                continue;
            }

            engineQueue.enqueue ( new Engine ( inpObj ) );
        }

        /*
         * Executes each program from engine queue.
         */
        while ( !engineQueue.isEmpty () )
            engineQueue.dequeue ().executeProgram ( args[1] );
    }
}
