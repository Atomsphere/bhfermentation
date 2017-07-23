/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import static BHFermentation.model.ProcessController.gpio;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;


/**
 *
 * @author Mark
 */
public class Heater extends Component {
    
    Heater(Pin heaterPin){//GPIO number to be determined later
       componentPin = gpio.provisionDigitalOutputPin(heaterPin, "Heater", PinState.LOW);
    }
}
