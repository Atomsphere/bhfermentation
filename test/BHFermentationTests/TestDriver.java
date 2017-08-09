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
    
    
    ProcessController testPC = new ProcessController();
    
    @Test
    public void heater1Test()
    {
        
        testPC.setHeater1(true);
        assertEquals("Result: false. Heater 1 should be set to true.", "On", testPC.getHeater1State());
    }
    
    @Test
    public void heater2Test()
    {
        testPC.setHeater2(true);
        assertEquals("Result: false. Heater 2 should be set to true.", "On", testPC.getHeater2State());
    }
    
    @Test
    public void fan1Test()
    {
        testPC.setFan1(true);
        assertEquals("Result: false. Fan 1 should be set to true.", "On", testPC.getFan1State());
    } 
    
    @Test
    public void fan2Test()
    {
        testPC.setFan2(true);
        assertEquals("Result: false. Fan 2 should be set to true.", "On", testPC.getFan2State());
    } 

    
    @Test
    public void valveCCTest1()
    {
        testPC.setValve1(0);
        assertEquals("cc does not equal 4", 4, testPC.getCC());
    }
    
    @Test
    public void valve1Test1()
    {
        testPC.setValve1(1);
        assertEquals("cc does not equal 3", 3, testPC.getCC());
    }
    
    @Test
    public void valve2Test1()
    {
        testPC.setValve2(1);
        assertEquals("cc does not equal 2", 2, testPC.getCC());
    }
    
    @Test
    public void valve3Test1()
    {
        testPC.setValve3(1);
        assertEquals("cc does not equal 1", 1, testPC.getCC());
    }
    
    }
    
   
 
