/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data.Chamber;
import BHFermentation.data.Sensor;
import java.util.List;
/**
 *
 * @author Mark
 */
public class Chamber {
    private Sensor chamber;
    private List<Vessel> vessels;
    
    public List<Vessel> getVessels(){
        return vessels;
    }
    
}
