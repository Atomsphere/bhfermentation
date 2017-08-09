/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;
import com.pi4j.io.gpio.PinState;
import static BHFermentation.model.ProcessController.GPIO;
import com.pi4j.io.gpio.Pin;

/**
 *
 * @author Mark Maupin
 */
public class Chiller extends Component {
    //private final Sensor sensor;
    
    Chiller(Pin pin){
       componentPin = GPIO.provisionDigitalOutputPin(pin, "Chiller", PinState.LOW);
       //sensor = new Sensor();
    }
}
