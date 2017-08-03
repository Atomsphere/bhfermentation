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
 * currently unsupported. I don't know of hardware that is going to be on I2C
 * Maybe the value representing % open of the valves
 * @author Mark
 */
public class Bus {
    
    static I2CBus bus;

    Alert alert;
    
    Bus()throws IOException, UnsupportedBusNumberException{
        bus = I2CFactory.getInstance(I2CBus.BUS_1);
        }
}
