/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;
import static BHFermentation.model.ProcessController.gpio;
import com.pi4j.io.gpio.PinState;
import static com.pi4j.io.gpio.RaspiPin.GPIO_11;

/**
 *
 * @author Mark
 */
public class Chiller extends Component {
    private final Sensor sensor;
    
    Chiller(){
       componentPin = gpio.provisionDigitalOutputPin(GPIO_11, "Chiller", PinState.LOW);
       sensor = new Sensor();
    }
}
