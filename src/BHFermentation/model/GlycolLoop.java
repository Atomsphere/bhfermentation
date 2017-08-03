/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

//GPIO imports: 29 is free. 15 and 16 reserved TxD and RxD for 1-wire sensor
//Using pi4j pinout, differs from Broadcom's. more info at
//http://pi4j.com/images/j8header-b-plus-large.png
import static com.pi4j.io.gpio.RaspiPin.GPIO_00; //fan 1
import static com.pi4j.io.gpio.RaspiPin.GPIO_01; //heater 1
import static com.pi4j.io.gpio.RaspiPin.GPIO_02; //fan 2
import static com.pi4j.io.gpio.RaspiPin.GPIO_03; //heater 2
import static com.pi4j.io.gpio.RaspiPin.GPIO_04; //pump
import static com.pi4j.io.gpio.RaspiPin.GPIO_05; //chiller
import static com.pi4j.io.gpio.RaspiPin.GPIO_06; //chest freezer
import static com.pi4j.io.gpio.RaspiPin.GPIO_07; //ice tank
import static com.pi4j.io.gpio.RaspiPin.GPIO_21; //bypass valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_22; //bypass valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_23; //chamber 1 valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_24; //chamber 1 valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_25; //chamber 2 valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_26; //chamber 2 valve close
import static com.pi4j.io.gpio.RaspiPin.GPIO_27; //ice tank valve open
import static com.pi4j.io.gpio.RaspiPin.GPIO_28; //ice tank valve close

/**
 *
 * @author Mark
 */
public class GlycolLoop {
    
    final Valve bypass, c1Valve, c2Valve, iCValve;
    //final Bypass bypass;
    final ChestFreezer chestFreezer;
    final Pump pump;
    final Chiller chiller;
    final Sensor sensor;
    final Chamber chamber1, chamber2;
    final IceTank iceTank;
    
    /**
     * Constructs the Glycol Loop subsystem
     * GPIO pins are ordered in loose organization
     */
    GlycolLoop(){
        chamber1 = new Chamber(GPIO_00, GPIO_01);
        chamber2 = new Chamber(GPIO_02, GPIO_03);
        
        pump = new Pump(GPIO_04);
        chiller = new Chiller(GPIO_05);
        chestFreezer = new ChestFreezer(GPIO_06);
        iceTank = new IceTank(GPIO_07);
        
        bypass = new Valve(GPIO_21, GPIO_22);
        c1Valve = new Valve(GPIO_23, GPIO_24);
        c2Valve = new Valve(GPIO_25, GPIO_26);
        iCValve = new Valve(GPIO_27, GPIO_28);
        
        sensor = new Sensor();

    }
    
    public void getPressure(){
        
    }
    
    
}
