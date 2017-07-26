/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Mark
 */
public class ProcessController extends Application{

    
    final static GpioController gpio = GpioFactory.getInstance();
    
    private static final GlycolLoop GLYCOLLOOP = new GlycolLoop();
    private final Clock clock = new Clock();
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
    
     public static void main(String[] args) {
        launch(args);
    }
    
    /**
     *  default constructor
     */
    public ProcessController(){
        
        
    }
    
    
    
    /**
     * to be filled out later
     */
    public class PID{
        private float kph, kdh, kih;
        private float kpc, kdc, kic;
        
        
        
        public void cooling(int setpoint, int interval, String keyword){
            
        }
        
        public void heating(int setpoint, int interval, String keyword){
            
        }
        
        public void heatingTune(){
            
        }
        
        public void coolingTune(){
            
        }
}
}
