/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;


/**
 *
 * @author Mark
 */
public class Heater extends Component {
    
    Heater(Pin heaterPin){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(heaterPin, "Heater", PinState.LOW);
    }
}
