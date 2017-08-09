/*
 *  CS4398 - Group 3 - Summer 2 - 2017
 */
package BHFermentation.model;

import BHFermentation.view.JFrameView;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;
import javax.swing.table.*;

/**
 * Provides an interface for the view/controller
 * Defines some amount of functionality
 * @author Mark Maupin
 */
public class ProcessController {

    static GpioController GPIO;
    static  GlycolLoop glycolLoop;
    public double temp[];
    public double setPoint[]; //c1v1..c1v4..c2v1...c2v4...CF...IT t.f. size = 10
    public String componentState[];
    public String recipe[];
    
    private final ScheduledExecutorService scheduler =
       Executors.newScheduledThreadPool(1);
    /**
     *  default constructor
     * Instantiates the GPIO factory, therefore acts as the interface for the PI
     * Creates an instance of GlycolLoop which contains most objects
     */
    public ProcessController(){
        GPIO = GpioFactory.getInstance();
        glycolLoop = new GlycolLoop();
        temp = new double[2];
        setPoint = new double[10];
        componentState = new String[20]; //currently oversized
        recipe = new String[8];
        for(int i =0; i < 8; i++){ //can be replaced with fill
            recipe[i] = "-";
        }
        temp[0] = glycolLoop.getTemp1();
        temp[1] = glycolLoop.getTemp2();
        timerInSeconds();
    }
    
    
    /**
    * A timer to poll for current temperature. Also sets the resolution
    * for updating the table. Currently set at 10 seconds
    * In future builds, constants will be replaced with variables
    * so that operations can be automated
    */
    private void timerInSeconds() {
        final Runnable timer = this::updateTemps;
        final ScheduledFuture<?> updateHandle =
            scheduler.scheduleAtFixedRate(timer, 1, 1, SECONDS);
        scheduler.schedule(() -> {
            updateHandle.cancel(true);
        }, 60 * 60, SECONDS);
    }
    
    /**
     * Called by timerInSeconds. Sends update notifications to view
     */
    public void updateTemps(){
        temp[0] = glycolLoop.getTemp1();
        temp[1] = glycolLoop.getTemp2();
        JFrameView.chamber1Table.setValueAt(temp[0], 0, 2);
        JFrameView.chamber1Table.setValueAt(temp[1], 1, 2);
        JFrameView.chamber1Table.setValueAt(temp[0], 2, 2);
        JFrameView.chamber1Table.setValueAt(temp[1], 3, 2);
        
        JFrameView.chamber2Table.setValueAt(temp[0], 0, 2);
        JFrameView.chamber2Table.setValueAt(temp[1], 1, 2);
        JFrameView.chamber2Table.setValueAt(temp[0], 2, 2);
        JFrameView.chamber2Table.setValueAt(temp[1], 3, 2);
        
        JFrameView.sensorsTable.setValueAt(temp[0], 0, 1);
        JFrameView.sensorsTable.setValueAt(temp[1], 1, 1);
        JFrameView.sensorsTable.setValueAt(temp[0], 2, 1);
        JFrameView.sensorsTable.setValueAt(temp[1], 3, 1);
        JFrameView.sensorsTable.setValueAt(temp[1], 4, 1);
    }
    
    /**
     * Allows setpoints to be updated
     * sends update to view
     * @parm value
     * @param row
     * @param value 
     * @param tableID 0 =chamber1, 1 =chamber2, 2 =components, 3 =valves, 4 =sensors
     */
    public void updateData(String value, int row, int col, int tableID){
        
        switch(tableID){
            case 0:
                JFrameView.chamber1Table.setValueAt(value, row, col);
                break;
            case 1:
                JFrameView.chamber2Table.setValueAt(value, row, col);
                break;
            case 2:
                JFrameView.componentsTable.setValueAt(value, row, col);
                break;
            case 3:
                JFrameView.valveTable.setValueAt(value, row, col);
                break;
            
        }
       
    }
    
    
    /**
     * Sets heater 1's state on/off
     * @param state 
     */
    public void setHeater1(boolean state){
        glycolLoop.chamber1.heater.setState(state);
    }
    
    /**
     * getter for heater state
     * @return string on if true, off otherwise
     */
    public String getHeater1State(){
        if (glycolLoop.chamber1.heater.getState()){
            return "On";
        }
        else return "off";
    }
    
    /**
     * setter for heater 2
     * @param state
     */
    public void setHeater2(boolean state){
        glycolLoop.chamber2.heater.setState(state);
    }
    
    /**
     * getter for heater 2
     * @return on if true, off otherwise
     */
    public String getHeater2State(){
        if (glycolLoop.chamber2.heater.getState()){
            return "On";
        }
        else return "off";
    }
    
    /**
     * setter for fan 1
     * @param state 
     */
    public void setFan1(boolean state){
        glycolLoop.chamber1.fan.setState(state);
    }
    
    /**
     * getter for fan 1
     * @return on if true, off otherwise
     */
    public String getFan1State(){
        if (glycolLoop.chamber1.fan.getState())
            return "On";
        else return "off";
    }
    
    /**
     * setter for fan 2
     * @param state 
     */
    public void setFan2(boolean state){
        glycolLoop.chamber2.fan.setState(state);
    }
    
    /**
     * getter for fan 2
     * @return on if true, off otherwise
     */
    public String getFan2State(){
        if (glycolLoop.chamber2.fan.getState())
            return "On";
        else return "off";
    }
    
    /**
     * setter for valve 1- glycolloop's chamber 1
     * @param state ternary flag, 0 = acs, 1 = open, 2 = close
     */
    public void setValve1(int state){
        int cc = glycolLoop.c1Valve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    /**
     * setter for valve 2- glycolloop's chamber 2
     * @param state ternary flag, 0 = acs, 1 = open, 2 = close
     */
    public void setValve2(int state){
        int cc = glycolLoop.c2Valve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    /**
     * setter for valve 3- glycolloop's chamber ice tank
     * @param state ternary flag, 0 = acs, 1 = open, 2 = close
     */
    public void setValve3(int state){
        int cc = glycolLoop.iCValve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    /**
     * setter for bypass valve
     * @param state ternary flag, 0 = acs, 1 = open, 2 = close
     */
    public void setBypass(int state){
        glycolLoop.bypass.valveControl(state);
    }
    

    /**
     * setter for the chest freezer
     * @param state 
     */
    public void setChestFreezer(boolean state){
        glycolLoop.chestFreezer.setState(state);
    }
    
    /**
     * setter for the chiller
     * @param state 
     */
    public void setChiller(boolean state){
        glycolLoop.chiller.setState(state);
    }

    /**
     * setter for the ice tank
     * @param state 
     */
    public void setIce(boolean state){
        //glycolLoop.iceTank.setState(state);
    }
    
    /**
     * setter for the pump
     * despite override setting, will open bypass if all valves are closed
     * to prevent the pump from breaking. there is a hardcoded safety "feature"
     * @param state 
     */
    public void setPump(boolean state){
        if(glycolLoop.bypass.getCount() == 4){
            glycolLoop.bypass.ACS(true);
            setBypass(1);
        }
        glycolLoop.pump.setState(state);
    }
    
    /**
     * chamber 1 vessel 1 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel1Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel1.setState(activity, recipe);
        glycolLoop.chamber1.vessel1.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 1 vessel 2 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel2Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel2.setState(activity, recipe);
        glycolLoop.chamber1.vessel2.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 1 vessel 3 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel3Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel3.setState(activity, recipe);
        glycolLoop.chamber1.vessel3.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 1 vessel 4 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel4Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel4.setState(activity, recipe);
        glycolLoop.chamber1.vessel4.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 2 vessel 1 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel1Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel1.setState(activity, recipe);
        glycolLoop.chamber2.vessel1.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 2 vessel 2 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel2Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel2.setState(activity, recipe);
        glycolLoop.chamber2.vessel2.updateSetPoint(setPoint);
    }
    
    /**
     * chamber 2 vessel 3 setter
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel3Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel3.setState(activity, recipe);
        glycolLoop.chamber2.vessel3.updateSetPoint(setPoint);
    }
    
    /**chamber 2 vessel 4 setter
     * 
     * @param activity
     * @param recipe
     * @param setPoint 
     */
    public void setVessel4Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel4.setState(activity, recipe);
        glycolLoop.chamber2.vessel4.updateSetPoint(setPoint);
    }
  
    /**
     * chamber 1 vessel 1 recipe getter
     * @return recipe
     */
    public String c1v1Recipe(){
        return glycolLoop.chamber1.vessel1.getRecipe();
    }
    
    /**
     * chamber 1 vessel 2 recipe getter
     * @return recipe
     */
    public String c1v2Recipe(){
        return glycolLoop.chamber1.vessel2.getRecipe();
    }
    
    /**
     * chamber 1 vessel 3 recipe getter
     * @return recipe
     */
    public String c1v3Recipe(){
        return glycolLoop.chamber1.vessel3.getRecipe();
    }
    
    /**
     * chamber 1 vessel 4 recipe getter
     * @return recipe
     */
    public String c1v4Recipe(){
        return glycolLoop.chamber1.vessel4.getRecipe();
    }
  
    /*
    added more getter functions ******getters for testing******
    @author Lane M
    */
    
    public boolean getChestFreezerState()
    {
        return glycolLoop.chestFreezer.getState();
    }
  
    public boolean getBypassState()
    {
        return glycolLoop.bypass.getState();
    }
  
    public boolean getChillerState()
    {
        return glycolLoop.chiller.getState();
    }
  
    public String c2v1Recipe(){
        return glycolLoop.chamber2.vessel1.getRecipe();
    }
    
    public String c2v2Recipe(){
        return glycolLoop.chamber2.vessel2.getRecipe();
    }
    
    public String c2v3Recipe(){
        return glycolLoop.chamber2.vessel3.getRecipe();
    }
    
    public String c2v4Recipe(){
        return glycolLoop.chamber2.vessel4.getRecipe();
    }
    
    /*
    these are just plain ol' getter functions! nothin to see here
    @author Lane M
    */
    public boolean c1v1Activity(){
        return glycolLoop.chamber1.vessel1.getstate();
    }
    
    public boolean c1v2Activity(){
        return glycolLoop.chamber1.vessel2.getstate();
    }
    
    public boolean c1v3Activity(){
        return glycolLoop.chamber1.vessel3.getstate();
    }
    
    public boolean c1v4Activity(){
        return glycolLoop.chamber1.vessel4.getstate();
    }
    
    public boolean c2v1Activity(){
        return glycolLoop.chamber2.vessel1.getstate();
    }
    
    public boolean c2v2Activity(){
        return glycolLoop.chamber2.vessel2.getstate();
    }
    
    public boolean c2v3Activity(){
        return glycolLoop.chamber2.vessel3.getstate();
    }
    
    public boolean c2v4Activity(){
        return glycolLoop.chamber2.vessel4.getstate();
    }
    
    /*
    getters for the set point
    @author Lane M
    */
    public int c1v1SetPoint(){
        return glycolLoop.chamber1.vessel1.getSetPoint();
    }
    
    public int c1v2SetPoint(){
        return glycolLoop.chamber1.vessel2.getSetPoint();
    }

    public int c1v3SetPoint(){
        return glycolLoop.chamber1.vessel3.getSetPoint();
    }
    
    public int c1v4SetPoint(){
        return glycolLoop.chamber1.vessel4.getSetPoint();
    }
    
    public int c2v1SetPoint(){
        return glycolLoop.chamber2.vessel1.getSetPoint();
    }
    
    public int c2v2SetPoint(){
        return glycolLoop.chamber2.vessel2.getSetPoint();
    }
    
    public int c2v3SetPoint(){
        return glycolLoop.chamber2.vessel3.getSetPoint();
    }
    
    public int c2v4SetPoint(){
        return glycolLoop.chamber2.vessel4.getSetPoint();
    }
    
    
    public double gettemp1(){
        
        return glycolLoop.getTemp1();
    }
    
    public int getCC()
    {
        return glycolLoop.bypass.getCount();
    }
}
