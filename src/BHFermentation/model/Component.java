/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;


import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import java.util.Observable;



/**
 *
 * @author Mark Maupin
 */
public abstract class Component extends Observable{
    
    GpioPinDigitalOutput componentPin;
    
    Component(){
        
    }
    
    /**
     * sets state of a GPIO output Pin
     * receives boolean, if true energize
     * else de energize
     * @param state 
     */
    public void setState(boolean state){
        if(state){
            componentPin.setState(PinState.HIGH);
        }else{
            componentPin.setState(PinState.LOW);
        }
        setChanged();
        notifyObservers();
    }
     
    public boolean getState(){
        return componentPin.isHigh();
    }
}
