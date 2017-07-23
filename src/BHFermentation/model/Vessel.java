/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

/**
 *
 * @author Mark
 */
public class Vessel {
    
    private final Sensor sensor;
    private boolean state; //active or ready
    
    public Vessel(){
        sensor = new Sensor();
    }
    public boolean getstate(){
        return this.state;
    }
    
    public void setState(boolean state){
        this.state = state;
    }
}
