/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import java.util.List;
/**
 *
 * @author Mark
 */
public class Chamber {
    private Sensor sensor;
    private List<Vessel> vessels;
    
    Chamber(){
        
    }
    
    public List<Vessel> getVessels(){
        return vessels;
    }
    
}
