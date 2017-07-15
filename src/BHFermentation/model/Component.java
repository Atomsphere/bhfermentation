/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;


import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;



/**
 *
 * @author Mark
 */
public abstract class Component {
    
    GpioPinDigitalInput componentPin;
    
    Component(){
        
    }
    
    public void ComponentListen(){
        componentPin.addListener((GpioPinListenerDigital) (GpioPinDigitalStateChangeEvent event) -> {
            ProcessController.notify(event.getPin(), event.getState());
            });
    }    
    
}
