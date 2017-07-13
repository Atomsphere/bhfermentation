/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data.GlycolLoop;
import BHFermentation.data.Sensor;

import java.util.List;

/**
 *
 * @author Mark
 */
public class GlycolLoop {
    private List<Valve> valves;
    private Bypass bypass;
    private Pump pump;
    private Chiller chiller;
    private Sensor glycolTemp;
    /**
     * convert to observer
     * @return 
     */
    public int getGlycolTemp(){
        return glycolTemp.getTemp();
    }
    /**
     * 
     * @return 
     */
    public boolean getPumpStatus(){
        return pump.getState();
    }
    /**
     * Methods should be convereted to observers
     * this will be pull from an iterator
     * @return 
     */
    public int getValveStatus(){
        for()
        return 
    }
}
