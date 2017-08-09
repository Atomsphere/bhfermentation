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
public class ComponentObserver implements Observer {

    boolean state;
    int tableID;
    int row;
    int col;
    
    public ComponentObserver(Component component, int row, int col, int tableID){
        component.addObserver(this);
        this.state = component.getState();
        this.tableID = tableID;
        this.row = row;
        this.col = col;
    }
    @Override
    public void update(Observable o, Object arg) {
        Component component = (Component)o;
        
        if(state ^ component.getState()){
            state = component.getState();
            JFrameView.processController.updateData(Boolean.toString(state), row, col, tableID);
        }
    }
    
}
