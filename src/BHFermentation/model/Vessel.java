/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

/**
 *
 * @author Mark
 */
public class Vessel {
    
    private final Sensor sensor;
    private boolean state = false; //active or ready
    private String recipe = "-";
    int setPoint;
    
    public Vessel(){
        this.setPoint = 68;
        sensor = new Sensor();
    }
    public boolean getstate(){
        return this.state;
    }
    
    public void setState(boolean state, String recipe){
        this.state = state;
        this.recipe = recipe;
    }
    
    public void updateSetPoint(int setPoint){
        this.setPoint = setPoint;
    }
    
    public String getRecipe(){
        return recipe;
    }
}
