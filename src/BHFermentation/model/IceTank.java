/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.PinState;
import static com.pi4j.io.gpio.RaspiPin.GPIO_18;
import static BHFermentation.model.ProcessController.GPIO;

/**
 *
 * @author Mark
 */
public class IceTank extends Component{
    private final Sensor sensor;
    IceTank(){//GPIO number to be determined later
       componentPin = GPIO.provisionDigitalOutputPin(GPIO_18, "Chiller", PinState.LOW);
       sensor = new Sensor();
    }
}
