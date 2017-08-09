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
 * @author Maupin
 */
public class ValveObserver implements Observer{

    boolean close;
    int row;
    
    public ValveObserver(Valve valve, int row){
        valve.addObserver(this);
        close = valve.getState();
        this.row = row;
    }
    @Override
    public void update(Observable o, Object arg) {
        Valve valve = (Valve)o;
        //if(close ^ valve.getState()){
            close = valve.getState();
            if(close){
                JFrameView.processController.updateData("on", row, 2, 3);
                JFrameView.processController.updateData("off", row, 1, 3);
            }else{
                JFrameView.processController.updateData("off", row, 2, 3);
                JFrameView.processController.updateData("on", row, 1, 3);
            }
                
        //}
    }
    
}
