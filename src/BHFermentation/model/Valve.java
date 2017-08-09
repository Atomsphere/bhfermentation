/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import java.util.Observable;

/**
 * Valve provides methods for opening and closing valves
 * needs logic from I2C for current percentage
 * @author Mark Maupin
 */
public class Valve extends Observable{
    private final GpioPinDigitalOutput open;
    private final GpioPinDigitalOutput close;
    boolean acs = true;
    static int closedCount = 4;
    Valve(Pin open, Pin close){
        this.open = GPIO.provisionDigitalOutputPin(open, "Valve Open", PinState.LOW);
        this.close = GPIO.provisionDigitalOutputPin(close, "Valve Close", PinState.HIGH);
        
    }
    
    /**
     * sets the pin close as off
     * opens the valve
     */
    private void Open(){
        if(close.isHigh()){
            closedCount--;
            close.setState(PinState.LOW);
        }

        open.setState(PinState.HIGH);
        setChanged();
        notifyObservers();
    }
    
    /**
     * sets the pin open as off
     * closes the valve
     */
    private void Close(){
        if(open.isHigh()){
            closedCount++;
            open.setState(PinState.LOW);
        }
        
        close.setState(PinState.HIGH);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Not implemented in this version. We're assuming a binary state for the
     * valves
     */
    public void Stop(){
        
    }
    
    public int valveControl(int state){
        switch (state){
            case 0: 
                ACS(true);
                return closedCount;
            case 1:
                Open();
                ACS(false);
                
                return closedCount;
            case 2:
                Close();
                ACS(false);
                
                return closedCount;
            default:
                return closedCount;
        }
    }
    
    void ACS(boolean state){
        this.acs = state;
    }
    
    public boolean getState(){
        return close.isHigh();
    }
    
    public int getCount(){
        return closedCount;
    }
    
    public boolean getACS(){
        return acs;
    }
}
