/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;


import com.pi4j.io.gpio.PinState;
import static com.pi4j.io.gpio.RaspiPin.GPIO_23;
import static BHFermentation.model.ProcessController.GPIO;

/**
 *
 * @author Mark
 */
public class Pump extends Component{
    Pump(){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(GPIO_23, "Pump", PinState.LOW);
    
    }
}
