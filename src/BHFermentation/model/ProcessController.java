/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;



/**
 *
 * @author Mark
 */
public class ProcessController {

    
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
    
    
    
}
