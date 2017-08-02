/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Mark
 */
public class ProcessController {

    
    List<Integer> temps = new ArrayList<>();
    List<String> activity = new ArrayList<>();
    List<Boolean> state = new ArrayList<>();
    
    
    final static GpioController GPIO = GpioFactory.getInstance();
    
    private static final GlycolLoop GLYCOLLOOP = new GlycolLoop();
    private final Clock clock = new Clock();
    /**
     * JavaFX replaces main with start
     * @param stage
     * @throws Exception 
     */
        
    /**
     *  default constructor
     */
    public ProcessController(){
        
        
    }
    
    public void setHeater1(boolean state){
        GLYCOLLOOP.setHeatChamber1(state);
    }
    
    
}
