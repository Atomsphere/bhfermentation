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
    
    private Sensor sensor;
    private boolean state; //active or ready
    
    public Vessel(){
        
    }
    public boolean getstate(){
        return this.state;
    }
}
