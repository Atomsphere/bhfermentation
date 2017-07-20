/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.view;

/**
 *
 * @author Mark
 */
public class Alert {
    String i2cMessages;
    
    Alert(){
        
    }
    
    public void setI2cAlert(String message){
        this.i2cMessages = message;
    }
}
