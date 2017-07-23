/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import static BHFermentation.model.ProcessController.gpio;
import com.pi4j.io.gpio.PinState;
import static com.pi4j.io.gpio.RaspiPin.GPIO_07;

/**
 *
 * @author Mark
 */
public class ChestFreezer extends Component{
    private final Sensor sensor1, sensor2;
    
    ChestFreezer(){
    componentPin = gpio.provisionDigitalOutputPin(GPIO_07, "Chest Freezer", PinState.LOW);
    sensor1 = new Sensor();
    sensor2 = new Sensor();
    }
    
    private Sensor chestFreezer;
    
    
}
