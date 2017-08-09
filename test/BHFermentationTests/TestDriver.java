/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentationTests;


import BHFermentation.model.ProcessController;
import junit.framework.TestCase;





/**
 *  As of yet unsure which classes need to be targeted for testing
 * @author Lane M
 * @author Mark Maupin
 */
public class TestDriver extends TestCase{
    private static final ProcessController testPC = new ProcessController();
   
   
    
    public void testHeater1()
    
    {
        
        testPC.setHeater1(true);
        assertEquals("Result: false. Heater 1 should be set to true.", "On", testPC.getHeater1State());
    }
    
    public void testHeater2()
    {
        
        testPC.setHeater2(true);
        assertEquals("Result: false. Heater 2 should be set to true.", "On", testPC.getHeater2State());
    }
    
    public void testFan1()
    {
        
        testPC.setFan1(true);
        assertEquals("Result: false. Fan 1 should be set to true.", "On", testPC.getFan1State());
    } 
    
    public void testFan2()
    {
        
        testPC.setFan2(true);
        assertEquals("Result: false. Fan 2 should be set to true.", "On", testPC.getFan2State());
    } 

    
}
    
   
 
