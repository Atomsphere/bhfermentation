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
 * @author Mark
 */
public class ChestFreezer extends Component{
    private final Sensor sensor1, sensor2;
    
    ChestFreezer(Pin pin){
    componentPin = GPIO.provisionDigitalOutputPin(pin, "Chest Freezer", PinState.HIGH);
    sensor1 = new Sensor();
    sensor2 = new Sensor();
    }
    
    private Sensor chestFreezer;
    
    
}
