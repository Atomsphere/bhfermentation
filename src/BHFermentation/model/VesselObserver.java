/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import BHFermentation.view.JFrameView;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mark Maupin
 */
public class VesselObserver implements Observer{
    private String recipe;
    private boolean state;
    private double setPoint;
    private int ID;
    int chamberID;
    
    public VesselObserver(Vessel vessel, int chamberID){
        vessel.addObserver(this);
        recipe = vessel.getRecipe();
        state = vessel.getstate();
        setPoint = vessel.getSetpoint();
        ID = vessel.getID();
        this.chamberID = chamberID;
    }

    @Override
    public void update(Observable o, Object arg) {
        Vessel vessel = (Vessel)o;
        if(!recipe.equals(vessel.getRecipe())){
            recipe = vessel.getRecipe();
            JFrameView.processController.updateData(recipe, ID, 3,chamberID);
        }
        if(setPoint != vessel.getSetpoint()){
            setPoint = vessel.getSetpoint();
            JFrameView.processController.updateData(Double.toString(setPoint), ID, 4,chamberID);
        }
        /*if(state ^ vessel.getstate()){ //xor not in use currently
        state = vessel.getstate();
        JFrameView.processController.updateData(Boolean.toString(state), ID, 2);
        }*/
    }
}
