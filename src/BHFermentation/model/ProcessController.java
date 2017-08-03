/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import static com.pi4j.io.gpio.RaspiPin.GPIO_01;
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
    static GpioController GPIO;
    //GpioPinDigitalOutput testing;   
    private static  GlycolLoop glycolLoop;
    
    //private final Clock clock = new Clock();
    /**
     * JavaFX replaces main with start
     * @param stage
     * @throws Exception 
     */
        
    /**
     *  default constructor
     */
    public ProcessController(){
        GPIO = GpioFactory.getInstance();
        glycolLoop = new GlycolLoop();
       // testing = GPIO.provisionDigitalOutputPin(GPIO_01);
    }
    
    public void setHeater1(boolean state){
        glycolLoop.setHeatChamber1(state);
    }
    
    
}
