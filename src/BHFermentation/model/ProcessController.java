/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark
 */
public class ProcessController {

    static GpioController GPIO;
    private static  GlycolLoop glycolLoop;
    
    /**
     *  default constructor
     */
    public ProcessController(){
        GPIO = GpioFactory.getInstance();
        glycolLoop = new GlycolLoop();
    }
    
    public void setHeater1(boolean state){
        glycolLoop.chamber1.heater.setState(state);
    }
    
    public String getHeater1State(){
        if (glycolLoop.chamber1.heater.getState()){
            return "On";
        }
        else return "off";
    }
    
    public void setHeater2(boolean state){
        glycolLoop.chamber2.heater.setState(state);
    }
    
    public String getHeater2State(){
        if (glycolLoop.chamber2.heater.getState()){
            return "On";
        }
        else return "off";
    }
    
    public void setFan1(boolean state){
        glycolLoop.chamber1.fan.setState(state);
    }
    
    public String getFan1State(){
        if (glycolLoop.chamber1.fan.getState())
            return "On";
        else return "off";
    }
    
    public void setFan2(boolean state){
        glycolLoop.chamber2.fan.setState(state);
    }
    
    public String getFan2State(){
        if (glycolLoop.chamber2.fan.getState())
            return "On";
        else return "off";
    }
    
    public void setValve1(int state){
        int cc = glycolLoop.c1Valve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    public void setValve2(int state){
        int cc = glycolLoop.c2Valve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    public void setValve3(int state){
        int cc = glycolLoop.iCValve.valveControl(state);
        if(cc > 2 && glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(1);
        else if(cc < 2 && !glycolLoop.bypass.getState() && glycolLoop.bypass.getACS())
            setBypass(2);
    }
    
    public void setBypass(int state){
        glycolLoop.bypass.valveControl(state);
    }
    
    public void setChestFreezer(boolean state){
        glycolLoop.chestFreezer.setState(state);
    }
    
    public void setChiller(boolean state){
        glycolLoop.chiller.setState(state);
    }
    
    public void setIce(boolean state){
        //glycolLoop.iceTank.setState(state);
    }
    
    public void setPump(boolean state){
        if(glycolLoop.bypass.getCount() < 4){
            setBypass(1);
        }
        glycolLoop.pump.setState(state);
    }
    
    public void setVessel1Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel1.setState(activity, recipe);
        glycolLoop.chamber1.vessel1.updateSetPoint(setPoint);
    }
    
    public void setVessel2Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel2.setState(activity, recipe);
        glycolLoop.chamber1.vessel2.updateSetPoint(setPoint);
    }
    
    public void setVessel3Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel3.setState(activity, recipe);
        glycolLoop.chamber1.vessel3.updateSetPoint(setPoint);
    }
    
    public void setVessel4Chamber1(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber1.vessel4.setState(activity, recipe);
        glycolLoop.chamber1.vessel4.updateSetPoint(setPoint);
    }
    
    public void setVessel1Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel1.setState(activity, recipe);
        glycolLoop.chamber2.vessel1.updateSetPoint(setPoint);
    }
    
    public void setVessel2Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel2.setState(activity, recipe);
        glycolLoop.chamber2.vessel2.updateSetPoint(setPoint);
    }
    
    public void setVessel3Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel3.setState(activity, recipe);
        glycolLoop.chamber2.vessel3.updateSetPoint(setPoint);
    }
    
    public void setVessel4Chamber2(boolean activity, String recipe, int setPoint){
        glycolLoop.chamber2.vessel4.setState(activity, recipe);
        glycolLoop.chamber2.vessel4.updateSetPoint(setPoint);
    }
    
    public String c1v1Recipe(){
        return glycolLoop.chamber1.vessel1.getRecipe();
    }
    
    public String c1v2Recipe(){
        return glycolLoop.chamber1.vessel2.getRecipe();
    }
    
    public String c1v3Recipe(){
        return glycolLoop.chamber1.vessel3.getRecipe();
    }
    
    public String c1v4Recipe(){
        return glycolLoop.chamber1.vessel4.getRecipe();
    }
    
    public double gettemp1(){
        
        return glycolLoop.getTemp1();
    }
}
