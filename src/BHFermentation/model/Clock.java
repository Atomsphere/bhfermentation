/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.i2c.*;
import static BHFermentation.model.Bus.bus;
import java.io.IOException;


/**
 *
 * @author Mark
 */
public class Clock{
    I2CDevice clock;
    Clock(){ 
       clock = null;
   } 
    
    /**
     * sets the clock to the user specified bus address
     * @param address
     * @throws IOException 
     */
    public void setClock(int address) throws IOException{
        clock = bus.getDevice(address);
    }
}
