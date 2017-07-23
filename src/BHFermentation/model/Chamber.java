/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.Pin;
import java.util.List;
/**
 *
 * @author Mark
 */
public class Chamber {
    private final Sensor sensor;
    private Vessel [] vessels;
    private final Fan fan;
    private final Heater heater;
    
    /**
     * Should not instantiate a chamber without a fan and a heater
     * @param fanPin
     * @param heaterPin 
     */
    Chamber(Pin fanPin, Pin heaterPin){
        sensor = new Sensor();
        for(int i = 0; i < 4; i++){
            vessels[i] = new Vessel();
        }
        fan = new Fan(fanPin);
        heater = new Heater(heaterPin);
    }
    
    /**
     * gets vessels associated with the chamber
     * @return 
     */
    public Vessel [] getVessels(){
        return vessels;
    }
    
    
}
