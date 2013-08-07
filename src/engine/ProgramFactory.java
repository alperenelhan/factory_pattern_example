/*
 * @(#)ProgramFactory.java   12/05/13
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

import engine.Process;

import engine.processes.*;

import tools.InputObject;
import tools.Queue;

/**
 *
 * @author oae
 */
public class ProgramFactory {

    /**
     * Constructs ProgramFactory
     *
     */
    public ProgramFactory () {}

    /**
     * Determines the program from given parameter.
     *
     *
     *
     * @param inpObj holds the given input variables from input file
     * @return process queue as a program
     */
    public Queue<Process> getProcessQueue ( InputObject inpObj ) {

        Queue<Process> procQueue = new Queue<Process> ();

        if ( inpObj.getProgram ().equals ( "A" ) ) {

            procQueue.enqueue ( new PreWash ( 5, 40, inpObj ) );
            procQueue.enqueue ( new Spinning ( 10, 30, inpObj ) );
            procQueue.enqueue ( new Rinsing ( 5, 20, inpObj ) );
            procQueue.enqueue ( new Extract ( 5, inpObj ) );
        }
        else if ( inpObj.getProgram ().equals ( "B" ) ) {

            procQueue.enqueue ( new PreWash ( 10, 40, inpObj ) );
            procQueue.enqueue ( new Spinning ( 15, 30, inpObj ) );
            procQueue.enqueue ( new Rinsing ( 10, 20, inpObj ) );
            procQueue.enqueue ( new Extract ( 10, inpObj ) );
        }
        else if ( inpObj.getProgram ().equals ( "C" ) ) {

            procQueue.enqueue ( new PreWash ( 10, 50, inpObj ) );
            procQueue.enqueue ( new Spinning ( 25, 30, inpObj ) );
            procQueue.enqueue ( new Rinsing ( 20, 25, inpObj ) );
            procQueue.enqueue ( new Extract ( 15, inpObj ) );
        }
        else if ( inpObj.getProgram ().equals ( "D" ) ) {

            procQueue.enqueue ( new PreWash ( 30, 60, inpObj ) );
            procQueue.enqueue ( new Spinning ( 35, 30, inpObj ) );
            procQueue.enqueue ( new Rinsing ( 20, 25, inpObj ) );
            procQueue.enqueue ( new Extract ( 15, inpObj ) );
        }
        else if ( inpObj.getProgram ().equals ( "E" ) ) {

            procQueue.enqueue ( new PreWash ( 15, 20, inpObj ) );
            procQueue.enqueue ( new Spinning ( 15, 30, inpObj ) );
            procQueue.enqueue ( new Rinsing ( 15, 40, inpObj ) );
            procQueue.enqueue ( new Spinning ( 15, 30, inpObj ) );
            procQueue.enqueue ( new Extract ( 15, inpObj ) );
        }

        return procQueue;
    }
}
