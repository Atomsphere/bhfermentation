/**
 * 
 */
package BHFermentation.model;

import static BHFermentation.model.Bus.bus;
import com.pi4j.io.i2c.I2CDevice;
import java.io.IOException;


/**
 *
 * @author Mark
 */
public class Sensor {
    
    int ID;
    private String alias;
    private I2CDevice sensor;
    
    /**
     * constructor
     */
    public Sensor(){
        sensor = null;
    }
    
    /**
     * simple getter for temp
     * @return integer value is a byte
     */
    
    /**
     * 
     * @param alias 
     */
    public void setSensor(String alias) throws IOException{
        this.alias = alias;
        
        try{
        setID();
        }catch(Exception a){
            
        }
        sensor = bus.getDevice(ID);
    }
    /**
     * table for establishing the Alias
     * @throws Exception if ID is not in the table
     */
    private void setID() throws Exception{
        switch (alias){
            case "TS1":   this.ID = 0x90;
            break;
            case "TS2":   this.ID = 0x92;
            break;
            case "TS3":   this.ID = 0x82;
            break;
            case "TS4":   this.ID = 0x80;
            break;
            case "TS5":   this.ID = 0x94;
            break;
            case "TS6":   this.ID = 0x96;
            break;
            case "TS7":   this.ID = 0x86;
            break;
            case "TS8":   this.ID = 0x84;
            break;
            case "TS9":   this.ID = 0xB4;
            break;
            case "TS10":   this.ID = 0xB6;
            break;
            case "TS11":   this.ID = 0xA6;
            break;
            case "TS12":   this.ID = 0xA4;
            break;
            case "TS13":   this.ID = 0xB0;
            break;
            case "TS14":   this.ID = 0xB2;
            break;
            case "TS15":   this.ID = 0xA2;
            break;
            case "TS16":   this.ID = 0xA0;
            break;
            case "TS17":   this.ID = 0x98;
            break;
            case "TS18":   this.ID = 0x9A;
            break;
            case "TS19":   this.ID = 0x8A;
            break;
            case "TS20":   this.ID = 0x88;
            break;
            case "TS21":   this.ID = 0x9C;
            break;
            case "TS22":   this.ID = 0x9E;
            break;
            case "TS23":   this.ID = 0x8E;
            break;
            case "TS24":   this.ID = 0x8C;
            break;
            case "TS25":   this.ID = 0xBC;
            break;
            case "TS26":   this.ID = 0xBE;
            break;
            case "TS27":   this.ID = 0xAE;
            break;
            case "TS28":   this.ID = 0xAC;
            break;
            case "TS29":   this.ID = 0xB8;
            break;
            case "TS30":   this.ID = 0xBA;
            break;
            case "TS31":   this.ID = 0xAA;
            break;
            case "TS32":   this.ID = 0xA8;
            break;
            default:
               throw new Exception ("ID not in table");
        }
    }

    
}
