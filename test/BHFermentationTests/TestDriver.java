/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentationTests;


import BHFermentation.model.ProcessController;
import org.junit.Test;
import static org.junit.Assert.*;




/**
 *  As of yet unsure which classes need to be targeted for testing
 * @author Lane M
 */
public class TestDriver {
    
    @Test
    public void heater1Test()
    {
        ProcessController testPC = new ProcessController();
        testPC.setHeater1(true);
        assertEquals("Result: false. Heater 1 should be set to true.", "On", testPC.getHeater1State());
    }
    
    @Test
    public void heater2Test()
    {
        ProcessController testPC = new ProcessController();
        testPC.setHeater2(true);
        assertEquals("Result: false. Heater 2 should be set to true.", "On", testPC.getHeater2State());
    }
    
    @Test
    public void fan1Test()
    {
        ProcessController testPC = new ProcessController();
        testPC.setFan1(true);
        assertEquals("Result: false. Fan 1 should be set to true.", "On", testPC.getFan1State());
    } 
    
    @Test
    public void fan2Test()
    {
        ProcessController testPC = new ProcessController();
        testPC.setFan2(true);
        assertEquals("Result: false. Fan 2 should be set to true.", "On", testPC.getFan2State());
    } 

    
    }
    
   
 
