/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import BHFermentation.view.Alert;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import java.io.IOException;

/**
 *
 * @author Mark
 */
public class Bus {
    
    static I2CBus bus;
//private final GpioPinDigitalInput sda = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);
    //private final GpioPinDigitalInput scl = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_DOWN);
    Alert alert;
    
    Bus()throws IOException, UnsupportedBusNumberException{
        bus = I2CFactory.getInstance(I2CBus.BUS_1);
        }
    
    
    
   // alert.setI2cAlert("I2C bus succesfully instantiated");
    
    //alert.setI2cAlert("IO exception on the bus");
    
    //alert.setI2cAlert("Bus 1 not found");
    
        
        
    
}
