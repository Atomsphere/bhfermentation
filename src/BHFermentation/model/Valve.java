/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

/**
 * Valve provides methods for opening and closing valves
 * needs logic from I2C for current percentage
 * @author Mark
 */
public class Valve {
    private final GpioPinDigitalOutput open;
    private final GpioPinDigitalOutput close;
    
    Valve(GpioPinDigitalOutput open, GpioPinDigitalOutput close){
        this.open = open;
        this.close = close;
    }
    
    /**
     * sets the pin close as off
     * opens the valve
     */
    public void Open(){
        if(close.isHigh())
            close.low();

        open.high();
    }
    
    /**
     * sets the pin open as off
     * closes the valve
     */
    public void Close(){
        if(open.isHigh())
            open.low();
        
        close.high();
    }
    
    /**
     * freezes valve state at current %
     */
    public void Stop(){
        if(open.isHigh())
            open.low();
        if(close.isHigh())
            close.low();
    }
}
