/**
 * 
 */
package BHFermentation.data;


/**
 *
 * @author Mark
 */
public class Sensor {
    private int temp;
    private int ID; // 2 bit hex
    private String alias;
    
    /**
     * constructor, needs ID of sensor to instantiate
     * @param id 
     * catch is unfinished
     */
    public Sensor(int id){
        this.ID = id;
        
        try{
        alias();
        }catch(Exception a){
            
        }
    }
    
    /**
     * simple getter for temp
     * @return integer value is a byte
     */
    public int getTemp(){
        return this.temp;
    }
    
    /**
     * table for establishing the Alias
     * @throws Exception if ID is not in the table
     */
    private void alias() throws Exception{
        switch (ID){
            case 0x90:   alias = "TS1";
            break;
            case 0x92:   alias = "TS2";
            break;
            case 0x82:   alias = "TS3";
            break;
            case 0x80:   alias = "TS4";
            break;
            case 0x94:   alias = "TS5";
            break;
            case 0x96:   alias = "TS6";
            break;
            case 0x86:   alias = "TS7";
            break;
            case 0x84:   alias = "TS8";
            break;
            case 0xB4:   alias = "TS9";
            break;
            case 0xB6:   alias = "TS10";
            break;
            case 0xA6:   alias = "TS11";
            break;
            case 0xA4:   alias = "TS12";
            break;
            case 0xB0:   alias = "TS13";
            break;
            case 0xB2:   alias = "TS14";
            break;
            case 0xA2:   alias = "TS15";
            break;
            case 0xA0:   alias = "TS16";
            break;
            case 0x98:   alias = "TS17";
            break;
            case 0x9A:   alias = "TS18";
            break;
            case 0x8A:   alias = "TS19";
            break;
            case 0x88:   alias = "TS20";
            break;
            case 0x9C:   alias = "TS21";
            break;
            case 0x9E:   alias = "TS22";
            break;
            case 0x8E:   alias = "TS23";
            break;
            case 0x8C:   alias = "TS24";
            break;
            case 0xBC:   alias = "TS25";
            break;
            case 0xBE:   alias = "TS26";
            break;
            case 0xAE:   alias = "TS27";
            break;
            case 0xAC:   alias = "TS28";
            break;
            case 0xB8:   alias = "TS29";
            break;
            case 0xBA:   alias = "TS30";
            break;
            case 0xAA:   alias = "TS31";
            break;
            case 0xA8:   alias = "TS32";
            break;
            default:
               throw new Exception ("ID not in table");
        }
    }

    
    
    
}
