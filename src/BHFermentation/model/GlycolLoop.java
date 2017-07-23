/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;
import static BHFermentation.model.ProcessController.gpio;
import static com.pi4j.io.gpio.RaspiPin.GPIO_08;
import static com.pi4j.io.gpio.RaspiPin.GPIO_10;
import static com.pi4j.io.gpio.RaspiPin.GPIO_12;
import static com.pi4j.io.gpio.RaspiPin.GPIO_13;
import static com.pi4j.io.gpio.RaspiPin.GPIO_15;
import static com.pi4j.io.gpio.RaspiPin.GPIO_16;
import static com.pi4j.io.gpio.RaspiPin.GPIO_19;
import static com.pi4j.io.gpio.RaspiPin.GPIO_21;
import static com.pi4j.io.gpio.RaspiPin.GPIO_23;
import static com.pi4j.io.gpio.RaspiPin.GPIO_27;
import static com.pi4j.io.gpio.RaspiPin.GPIO_29;
import static com.pi4j.io.gpio.RaspiPin.GPIO_31;

/**
 *
 * @author Mark
 */
public class GlycolLoop {
    
    private final Valve bypassValve, c1Valve, c2Valve, iCValve;
    private final ChestFreezer chestFreezer;
    private final Pump pump;
    private final Chiller chiller;
    final Sensor sensor;
    private final Chamber chamber1, chamber2;
    
    /**
     * constructor same as everything else, pin number to be decided later
     */
    GlycolLoop(){
        c1Valve = new Valve(gpio.provisionDigitalOutputPin(GPIO_13), gpio.provisionDigitalOutputPin(GPIO_15));
        c2Valve = new Valve(gpio.provisionDigitalOutputPin(GPIO_19), gpio.provisionDigitalOutputPin(GPIO_21));
        iCValve = new Valve(gpio.provisionDigitalOutputPin(GPIO_23), gpio.provisionDigitalOutputPin(GPIO_27));
        bypassValve = new Valve(gpio.provisionDigitalOutputPin(GPIO_29), gpio.provisionDigitalOutputPin(GPIO_31));
        chestFreezer = new ChestFreezer();
        sensor = new Sensor();
        pump = new Pump();
        chiller = new Chiller();
        chamber1 = new Chamber(GPIO_08, GPIO_10);
        chamber2 = new Chamber(GPIO_12, GPIO_16);
    }
    
}
