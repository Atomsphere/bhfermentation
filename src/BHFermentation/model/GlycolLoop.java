/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;
import static BHFermentation.model.ProcessController.gpio;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import static com.pi4j.io.gpio.RaspiPin.GPIO_24;

/**
 *
 * @author Mark
 */
public class GlycolLoop {
    private final GpioPinDigitalOutput c1VOpen; //Chamber 1 valve open
    private final GpioPinDigitalOutput c1VClose;
    private final GpioPinDigitalOutput c2VOpen;
    private final GpioPinDigitalOutput c2VClose;
    private final GpioPinDigitalOutput iceVOpen; //ice maker valve open
    private final GpioPinDigitalOutput iceVClose;
    private final GpioPinDigitalOutput bypassOpen;
    private final GpioPinDigitalOutput bypassClose;
    private final Valve bypass;
    private final Valve chamber1;
    private final Valve chamber2;
    private final Valve iceMaker;
    
    
    private Pump pump;
    private Chiller chiller;
    private Sensor glycolTemp;
    
    /**
     * constructor same as everything else, pin number to be decided later
     */
    GlycolLoop(){
        c1VOpen = gpio.provisionDigitalOutputPin(GPIO_24);
        c1VClose = gpio.provisionDigitalOutputPin(GPIO_24);
        c2VOpen = gpio.provisionDigitalOutputPin(GPIO_24);
        c2VClose = gpio.provisionDigitalOutputPin(GPIO_24);
        iceVOpen = gpio.provisionDigitalOutputPin(GPIO_24);
        iceVClose = gpio.provisionDigitalOutputPin(GPIO_24);
        bypassOpen = gpio.provisionDigitalOutputPin(GPIO_24);
        bypassClose = gpio.provisionDigitalOutputPin(GPIO_24);
        chamber1 = new Valve(c1VOpen, c1VClose);
        chamber2 = new Valve(c2VOpen, c2VClose);
        iceMaker = new Valve(iceVOpen, iceVClose);
        bypass = new Valve(bypassOpen, bypassClose);
    }
    /**
     * convert to observer
     * @return 
     */
    //public int getGlycolTemp(){
      //  return glycolTemp.getTemp();
    //}
    /**
     * 
     * @return 
     */
    //public boolean getPumpStatus(){
     //   return pump.getState();
    //}
    /**
     * Methods should be convereted to observers
     * this will be pull from an iterator
     * @return 
     */
    //public int getValveStatus(){
     //   for()
       // return 
    //}
}
