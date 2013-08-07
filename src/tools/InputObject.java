/*
 * @(#)InputObject.java   12/05/13
 * 
 * Copyright (c) 2005 your company name
 *
 * License agreement text here ...
 *
 *
 *
 */



package tools;

/**
 *
 * @author oae
 */
public class InputObject {

    private int    _heatingWaterEnergy;
    private int    _initialWaterDegree;
    private int    _kg;
    private String _program;
    private int    _revolutionEnergy;
    private int    _temperatureIncrement;

    /**
     * Constructs InputObject class
     *
     *
     * @param kg the weight of laundry
     * @param initialWaterDegree the degree of tap's water
     * @param temperatureIncrement the temperature of heating 1l water in 1min
     * @param heatingWaterEnergy the energy needs to increase the temperature of 1l water by 1C
     * @param revolutionEnergy the energy needs to spin the basket 1 revolution in 1 min
     * @param program one of the programs (A, B, C, D, E ...)
     */
    public InputObject ( int kg, int initialWaterDegree, int temperatureIncrement, int heatingWaterEnergy,
                         int revolutionEnergy, String program ) {

        _kg                   = kg;
        _initialWaterDegree   = initialWaterDegree;
        _temperatureIncrement = temperatureIncrement;
        _heatingWaterEnergy   = heatingWaterEnergy;
        _revolutionEnergy     = revolutionEnergy;
        _program              = program;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getHeatingWaterEnergy () {
        return _heatingWaterEnergy;
    }

    /**
     * Method description
     *
     *
     * @param _heatingWaterEnergy
     */
    public void setHeatingWaterEnergy ( int _heatingWaterEnergy ) {
        this._heatingWaterEnergy = _heatingWaterEnergy;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getInitialWaterDegree () {
        return _initialWaterDegree;
    }

    /**
     * Method description
     *
     *
     * @param _initialWaterDegree
     */
    public void setInitialWaterDegree ( int _initialWaterDegree ) {
        this._initialWaterDegree = _initialWaterDegree;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getKg () {
        return _kg;
    }

    /**
     * Method description
     *
     *
     * @param _kg
     */
    public void setKg ( int _kg ) {
        this._kg = _kg;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getRevolutionEnergy () {
        return _revolutionEnergy;
    }

    /**
     * Method description
     *
     *
     * @param _revolutionEnergy
     */
    public void setRevolutionEnergy ( int _revolutionEnergy ) {
        this._revolutionEnergy = _revolutionEnergy;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getTemperatureIncrement () {
        return _temperatureIncrement;
    }

    /**
     * Method description
     *
     *
     * @param _temperatureIncrement
     */
    public void setTemperatureIncrement ( int _temperatureIncrement ) {
        this._temperatureIncrement = _temperatureIncrement;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getProgram () {
        return _program;
    }

    /**
     * Method description
     *
     *
     * @param _program
     */
    public void setProgram ( String _program ) {
        this._program = _program;
    }
}
