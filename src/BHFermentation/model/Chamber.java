/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.Pin;
import java.util.Observable;
/**
 *
 * @author Mark
 */
public class Chamber extends Observable{
    
    public int temperature;
    private final Sensor sensor;
    Vessel vessel1, vessel2, vessel3, vessel4;
    final Fan fan;
    final Heater heater;
    
    /**
     * Should not instantiate a chamber without a fan and a heater
     * @param fanPin
     * @param heaterPin 
     */
    Chamber(Pin fanPin, Pin heaterPin){
        sensor = new Sensor();
        //for(int i = 0; i < 4; i++){
          //  vessels[i] = new Vessel();
        //}
        fan = new Fan(fanPin);
        heater = new Heater(heaterPin);
        temperature = 0;
    }
    
    /**
     * gets vessels associated with the chamber
     * @return 
     */
    public Vessel getVessels(){
        return vessel1;
    }
    
    public void changeTemperature(){
        for (int i = 0; i <100; i++){
            temperature++;
            setChanged();
            notifyObservers();
        }
        
    }
    
    public void setHeater(boolean state){
        heater.setState(state);
    }
    
    public int getTemperature(){
        return temperature;
    }
    
    public void setFan(boolean state){
        fan.setState(state);
    }
}
