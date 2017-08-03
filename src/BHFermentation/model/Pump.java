/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;


import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import static com.pi4j.io.gpio.RaspiPin.GPIO_00;

/**
 *
 * @author Mark
 */
public class Pump extends Component{
    Pump(){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(GPIO_00, "Pump", PinState.LOW);
    
    }
}
