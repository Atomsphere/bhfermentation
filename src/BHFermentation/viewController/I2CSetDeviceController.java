/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.viewController;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author admin
 */
public class I2CSetDeviceController {
    private final List<Observer> observers = new ArrayList<>();
    private final int [] devices;
    
    I2CSetDeviceController(){
        devices = new int [32];
    }
    
    /**
     * sets an object's I2C device's address
     * @param index
     * @param address 
     */
    public void setDevice(String alias, String object){
        
    }
    
    private int getID(String alias){
        switch (alias){
            case "TS1":   return 0x90;
            case "TS2":   return 0x92;
            case "TS3":   return 0x82;
            case "TS4":   return 0x80;
            case "TS5":   return 0x94;
            case "TS6":   return 0x96;
            case "TS7":   return 0x86;
            case "TS8":   return 0x84;
            case "TS9":   return 0xB4;
            case "TS10":   return 0xB6;
            case "TS11":   return 0xA6;
            case "TS12":   return 0xA4;
            case "TS13":   return 0xB0;
            case "TS14":   return 0xB2;
            case "TS15":   return 0xA2;
            case "TS16":   return 0xA0;
            case "TS17":   return 0x98;
            case "TS18":   return 0x9A;
            case "TS19":   return 0x8A;
            case "TS20":   return 0x88;
            case "TS21":   return 0x9C;
            case "TS22":   return 0x9E;
            case "TS23":   return 0x8E;
            case "TS24":   return 0x8C;
            case "TS25":   return 0xBC;
            case "TS26":   return 0xBE;
            case "TS27":   return 0xAE;
            case "TS28":   return 0xAC;
            case "TS29":   return 0xB8;
            case "TS30":   return 0xBA;
            case "TS31":   return 0xAA;
            case "TS32":   return 0xA8;
            default:    return 0;
        }
    }
}
