/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data;

/**
 *
 * @author Mark
 */
public abstract class Component {
    private boolean state;
    
    public boolean getState(){
        return this.state;
    }
    
    public void setState(boolean state){
        this.state = state;
    }
}
