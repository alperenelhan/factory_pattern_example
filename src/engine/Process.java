/*
 * @(#)Process.java   12/05/13
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

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;

/**
 *
 * @author oae
 */
public class Process {

    private int              _minute       = 1;
    public ArrayList<String> outputStrings = new ArrayList<String> ();
    private int              _cumulativeEnergyUsage;
    private int              _cumulativeWaterUsage;
    private int              _heat;
    private InputObject      _inputVars;
    private int              _instantEnergyUsage;
    private int              _instantWaterUsage;
    private int              _neededWater;
    private int              _revolution;
    private int              _time;

    /**
     * Executes the program's current process.
     *
     *
     * @param minute
     * @param cumulativeEnergyUsage
     * @param cumulativeWaterUsage
     *
     * @return
     */
    public int executeProcess ( int minute, int cumulativeEnergyUsage, int cumulativeWaterUsage ) {

        int i;

        _minute                = minute;
        _cumulativeEnergyUsage = cumulativeEnergyUsage;
        _cumulativeWaterUsage  = cumulativeWaterUsage;
        heatWater ();
        _instantEnergyUsage = _revolution * _inputVars.getRevolutionEnergy ();

        for ( i = _minute; i < _time + _minute; i++ ) {

            _cumulativeWaterUsage  += _instantWaterUsage;
            _cumulativeEnergyUsage += _instantEnergyUsage;
            outputStrings.add ( i + "," + toString () + "," + _instantWaterUsage + "," + _cumulativeWaterUsage + ","
                                + _instantEnergyUsage + "," + _cumulativeEnergyUsage );
            _instantWaterUsage = 0;
        }

        _minute = i;

        return _minute;
    }

    /**
     * Heats the water if water's initial degree is lower than needed degree.
     *
     */
    public void heatWater () {

        _instantWaterUsage = _neededWater;

        if ( _heat > _inputVars.getInitialWaterDegree () ) {

            int i;
            int duration = ( int ) Math.ceil ( ( ( double ) ( _heat - _inputVars.getInitialWaterDegree () )
                               / ( _inputVars.getTemperatureIncrement () ) ) * ( double ) _neededWater );

            _instantEnergyUsage = ( _neededWater * ( _heat - _inputVars.getInitialWaterDegree () )
                                    * _inputVars.getHeatingWaterEnergy () ) / duration;

            for ( i = _minute; i < duration + _minute; i++ ) {

                _cumulativeWaterUsage  += _instantWaterUsage;
                _cumulativeEnergyUsage += _instantEnergyUsage;
                outputStrings.add ( i + ",heating," + _instantWaterUsage + "," + _cumulativeWaterUsage + ","
                                    + _instantEnergyUsage + "," + _cumulativeEnergyUsage );
                _instantWaterUsage = 0;
            }

            _minute = i;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCumulativeEnergyUsage () {
        return _cumulativeEnergyUsage;
    }

    /**
     * Method description
     *
     *
     * @param _cumulativeEnergyUsage
     */
    public void setCumulativeEnergyUsage ( int _cumulativeEnergyUsage ) {
        this._cumulativeEnergyUsage = _cumulativeEnergyUsage;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCumulativeWaterUsage () {
        return _cumulativeWaterUsage;
    }

    /**
     * Method description
     *
     *
     * @param _cumulativeWaterUsage
     */
    public void setCumulativeWaterUsage ( int _cumulativeWaterUsage ) {
        this._cumulativeWaterUsage = _cumulativeWaterUsage;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getHeat () {
        return _heat;
    }

    /**
     * Method description
     *
     *
     * @param _heat
     */
    public void setHeat ( int _heat ) {
        this._heat = _heat;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public InputObject getInputVars () {
        return _inputVars;
    }

    /**
     * Method description
     *
     *
     * @param _inputVars
     */
    public void setInputVars ( InputObject _inputVars ) {
        this._inputVars = _inputVars;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getInstantEnergyUsage () {
        return _instantEnergyUsage;
    }

    /**
     * Method description
     *
     *
     * @param _instantEnergyUsage
     */
    public void setInstantEnergyUsage ( int _instantEnergyUsage ) {
        this._instantEnergyUsage = _instantEnergyUsage;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getInstantWaterUsage () {
        return _instantWaterUsage;
    }

    /**
     * Method description
     *
     *
     * @param _instantWaterUsage
     */
    public void setInstantWaterUsage ( int _instantWaterUsage ) {
        this._instantWaterUsage = _instantWaterUsage;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getMinute () {
        return _minute;
    }

    /**
     * Method description
     *
     *
     * @param _minute
     */
    public void setMinute ( int _minute ) {
        this._minute = _minute;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getNeededWater () {
        return _neededWater;
    }

    /**
     * Method description
     *
     *
     * @param _neededWater
     */
    public void setNeededWater ( int _neededWater ) {
        this._neededWater = _neededWater;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getRevolution () {
        return _revolution;
    }

    /**
     * Method description
     *
     *
     * @param _revolution
     */
    public void setRevolution ( int _revolution ) {
        this._revolution = _revolution;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getTime () {
        return _time;
    }

    /**
     * Method description
     *
     *
     * @param _time
     */
    public void setTime ( int _time ) {
        this._time = _time;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public ArrayList<String> getOutputStrings () {
        return outputStrings;
    }

    /**
     * Method description
     *
     *
     * @param outputStrings
     */
    public void setOutputStrings ( ArrayList<String> outputStrings ) {
        this.outputStrings = outputStrings;
    }
}
