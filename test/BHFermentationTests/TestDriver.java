/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentationTests;


import BHFermentation.model.ProcessController;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;





/**
 *  As of yet unsure which classes need to be targeted for testing
 * @author Lane M
 */
public class TestDriver extends TestCase
{
    private static final ProcessController testPC = new ProcessController();
    
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
    
    @Test
    public void vessel1C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v1 Recipe does not match", "Stout", testPC.c1v1Recipe());
    }
    
    @Test
    public void vessel2C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v2 Recipe does not match", "Stout", testPC.c1v2Recipe());
    }
    
    @Test
    public void vessel3C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v3 Recipe does not match", "Stout", testPC.c1v3Recipe());
    }
    
    @Test
    public void vessel4C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v4 Recipe does not match", "Stout", testPC.c1v4Recipe());
    }
    
    @Test
    public void vessel1C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v1 Recipe does not match", "Stout", testPC.c2v1Recipe());
    }
    
    @Test
    public void vessel2C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v2 Recipe does not match", "Stout", testPC.c2v2Recipe());
    }

    @Test
    public void vessel3C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v3 Recipe does not match", "Stout", testPC.c2v3Recipe());
    }  
    
    @Test
    public void vessel4C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v4 Recipe does not match", "Stout", testPC.c2v4Recipe());
    } 
    
    
    }
    
   
 
