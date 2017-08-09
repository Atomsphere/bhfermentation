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
    
    /*
    These methods test that the heater components are functioning properly
    it turns them on and checks their state
    @author Lane M
    */
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
    
    
    /*
    These methods test that the fan components are functioning properly
    it turns them on and checks their state
    @author Lane M
    */    
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

    /*
    These methods test that the valve components are functioning properly
    sets the states to open and checks that they open and that the closedCount 
    variable is static for all valves
    @author Lane M
    */    
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
    
    /*
    This method tests that the bypass component is functioning properly
    sets the state to 1 and checks the result
    @author Lane M
    */
    
    @Test
    public void bypassTest()
    {
        int state = 1;
        
        testPC.setBypass(state);
        assertEquals("Bypass has incorrect state", true, testPC.getBypassState());
    }


    /*
    These methods test that the vessel components are functioning properly
    it passes each vessel a recipe, activity, and setPoint
    then it checks to make sure the information is correct
    @author Lane M
    */    
    @Test
    public void vessel1C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v1 Recipe does not match", "Stout", testPC.c1v1Recipe());
        assertEquals("c1v1 Activity does not match", true, testPC.c1v1Activity());
        assertEquals("c1v1 Set Point does not match", 50, testPC.c1v1SetPoint());
    }
    
    @Test
    public void vessel2C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v2 Recipe does not match", "Stout", testPC.c1v2Recipe());
        assertEquals("c1v2 Activity does not match", true, testPC.c1v2Activity());
        assertEquals("c1v2 Set Point does not match", 50, testPC.c1v2SetPoint());
    }
    
    @Test
    public void vessel3C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v3 Recipe does not match", "Stout", testPC.c1v3Recipe());
        assertEquals("c1v3 Activity does not match", true, testPC.c1v3Activity());
        assertEquals("c1v3 Set Point does not match", 50, testPC.c1v3SetPoint());
    }
    
    @Test
    public void vessel4C1Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber1(activity, recipe, setPoint);
        
        assertEquals("c1v4 Recipe does not match", "Stout", testPC.c1v4Recipe());
        assertEquals("c1v4 Activity does not match", true, testPC.c1v4Activity());
        assertEquals("c1v4 Set Point does not match", 50, testPC.c1v4SetPoint());
    }
    
    @Test
    public void vessel1C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel1Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v1 Recipe does not match", "Stout", testPC.c2v1Recipe());
        assertEquals("c2v1 Activity does not match", true, testPC.c2v1Activity());
        assertEquals("c2v1 Set Point does not match", 50, testPC.c2v1SetPoint());
    }
    
    @Test
    public void vessel2C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel2Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v2 Recipe does not match", "Stout", testPC.c2v2Recipe());
        assertEquals("c2v2 Activity does not match", true, testPC.c2v2Activity());
        assertEquals("c2v2 Set Point does not match", 50, testPC.c2v2SetPoint());
    }

    @Test
    public void vessel3C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel3Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v3 Recipe does not match", "Stout", testPC.c2v3Recipe());
        assertEquals("c2v3 Activity does not match", true, testPC.c2v3Activity());
        assertEquals("c2v3 Set Point does not match", 50, testPC.c2v3SetPoint());
    }  
    
    @Test
    public void vessel4C2Test()
    {
        String recipe = "Stout";
        boolean activity = true;
        int setPoint = 50;
        
        testPC.setVessel4Chamber2(activity, recipe, setPoint);
        
        assertEquals("c2v4 Recipe does not match", "Stout", testPC.c2v4Recipe());
        assertEquals("c2v4 Activity does not match", true, testPC.c2v4Activity());
        assertEquals("c2v4 Set Point does not match", 50, testPC.c2v4SetPoint());
    } 


    /*
    These methods test that the chest freezer and chiller components are functioning properly
    it turns them on and then checks to make sure they are on
    @author Lane M
    */    
    @Test
    public void chestFreezerTest()
    {
        boolean state = true;
        
        testPC.setChestFreezer(state);
        assertEquals("Chest Freezer has incorrect state.", true, testPC.getChestFreezerState());
    }
    
    @Test
    public void chillerTest()
    {
        boolean state = true;
        
        testPC.setChiller(state);
        assertEquals("Chiller has incorrect state.", true, testPC.getChillerState());
    }
    
    }
    
   
 
