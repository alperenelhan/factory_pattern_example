/*
 * @(#)Queue.java   12/05/13
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

import java.util.LinkedList;

/**
 * Queue
 *
 *
 * @version        v1
 * @author         Osman Alperen Elhan
 *
 * @param <T>
 */
public class Queue<T> {

    private LinkedList<T> list;

    /**
     * Constructs Queue class
     *
     */
    public Queue () {
        list = new LinkedList<T> ();
    }

    /**
     * If queue is empty returns true
     * else returns false
     *
     *
     * @return true if empty else return false
     */
    public boolean isEmpty () {
        return ( list.size () == 0 );
    }

    /**
     * Calculates the length of queue
     *
     *
     * @return length of queue
     */
    public int length () {
        return list.size ();
    }

    /**
     * Adds given object to queue
     *
     *
     * @param item item that will be added to queue
     */
    public void enqueue ( T item ) {
        list.add ( item );
    }

    /**
     * Remove first item from queue and returns it
     *
     *
     * @return first item from queue
     */
    public T dequeue () {

        T item = list.get ( 0 );

        list.remove ( 0 );

        return item;
    }

    /**
     * Returns first item from queue without
     * deleting it
     *
     *
     * @return  first item from queue
     */
    public T peek () {
        return list.get ( 0 );
    }
}
