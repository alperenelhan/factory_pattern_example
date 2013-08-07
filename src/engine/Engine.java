/*
 * @(#)Engine.java   12/05/13
 * 
 * Copyright (c) 2005 your company name
 *
 * License agreement text here ...
 *
 *
 *
 */



package engine;

//~--- non-JDK imports --------------------------------------------------------

import tools.InputObject;
import tools.Queue;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.util.ArrayList;

/**
 *
 * @author oae
 */
public class Engine {

    private Queue<Process> processQueue;

    /**
     * Constructs Engine class
     *
     *
     * @param inpObj holds the given input variables from input file
     */
    public Engine ( InputObject inpObj ) {
        setProcessQueue ( inpObj );
    }

    /**
     * executes the each processes that in process queue.
     *
     *
     *
     * @param output output file name
     *
     * @throws IOException
     */
    public void executeProgram ( String output ) throws IOException {

        int  newMinute        = 1;
        int  cumulativeWater  = 0;
        int  cumulativeEnergy = 0;
        File f                = new File ( output );

        f.createNewFile ();

        FileWriter     o   = new FileWriter ( f );
        BufferedWriter out = new BufferedWriter ( o );

        while ( !processQueue.isEmpty () ) {

            newMinute        = processQueue.peek ().executeProcess ( newMinute, cumulativeEnergy, cumulativeWater );
            cumulativeEnergy = processQueue.peek ().getCumulativeEnergyUsage ();
            cumulativeWater  = processQueue.peek ().getCumulativeWaterUsage ();
            writeToFile ( out, processQueue.peek ().getOutputStrings () );
            processQueue.dequeue ();
        }

        out.close ();
    }

    /**
     * Writes all output strings to the output file.
     *
     *
     * @param out output file's buffered writer.
     * @param strings output strings to write in arraylist form.
     *
     * @throws IOException
     */
    private void writeToFile ( BufferedWriter out, ArrayList<String> strings ) throws IOException {

        for ( String s : strings ) {
            out.write ( s + "\n" );
        }
    }

    /**
     * Creates the program using programFactory class.
     * And gets the process queue from it.
     *
     *
     * @param inpObj holds the given input variables from input file
     */
    private void setProcessQueue ( InputObject inpObj ) {

        ProgramFactory processFact = new ProgramFactory ();

        processQueue = processFact.getProcessQueue ( inpObj );
    }
}
