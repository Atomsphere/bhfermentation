/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;

/**
 *
 * @author Mark
 */
public class ProcessController extends Application{
    private List<Double> Temperatures;
    private List<Boolean> ComponentStatus;
    private List<Boolean> ValveStatus;
    private final GpioController gpio = GpioFactory.getInstance();
    
    
    /**
     * JavaFX replaces main with start
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     *  default constructor
     */
    public ProcessController(){
        
    }
    
  
    boolean getComponentStatus(Component component){
        
    }
    
    double getSensor(Sensor sensor){
        
    }
    
    boolean initiateRecipe(){
        
    }
    
    int selectVessel(){
        
    }
    
    public class PID{
        private float kph, kdh, kih;
        private float kpc, kdc, kic;
        
        
        
        boolean cooling(int setpoint, int interval, String keyword){
            
        }
        
        boolean heating(int setpoint, int interval, String keyword){
            
        }
        
        public boolean heatingTune(){
            
        }
        
        public boolean coolingTune(){
            
        }
}
}
