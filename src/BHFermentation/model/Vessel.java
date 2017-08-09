/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import java.util.Observable;

/**
 *
 * @author Mark Maupin
 */
public class Vessel extends Observable{
    
    private boolean state = false; //active or ready
    private String recipe;
    double setPoint;
    int ID;
    int chamberID;
    
    public Vessel(int ID){
        this.recipe = "-";
        this.setPoint = 68;
        this.ID = ID;
    }
    public boolean getstate(){
        return this.state;
    }
    
    public double getSetpoint(){
        return setPoint;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setState(boolean state, String recipe){
        this.state = state;
        this.recipe = recipe;
        setChanged();
        notifyObservers();
    }
    
    public void updateSetPoint(int setPoint){
        this.setPoint = setPoint;
        setChanged();
        notifyObservers();
    }
    
    public String getRecipe(){
        return recipe;
    }
}
