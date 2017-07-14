/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import static BHFermentation.model.ProcessController.gpio;
import com.pi4j.io.gpio.PinPullResistance;
import static com.pi4j.io.gpio.RaspiPin.GPIO_24;

/**
 *
 * @author Mark
 */
public class Clock extends Component{
    Clock(){
       componentPin = gpio.provisionDigitalInputPin(GPIO_24, PinPullResistance.PULL_DOWN);
    super.ComponentListen();
   } 
}
