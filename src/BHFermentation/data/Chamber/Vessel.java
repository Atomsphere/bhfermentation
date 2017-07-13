/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data.Chamber;
import BHFermentation.data.Sensor;

/**
 *
 * @author Mark
 */
public class Vessel {
    
    private Sensor vessel;
    private boolean state; //active or ready
    
    public Vessel(){
        
    }
    public boolean getstate(){
        return this.state;
    }
}
