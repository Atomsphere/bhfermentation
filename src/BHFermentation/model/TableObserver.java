/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

    import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Mark
 */
public class TableObserver implements Observer {

//An observer of name changes.

    private int temperature;
    public TableObserver(Chamber cs) {
        cs.addObserver(this);
        temperature = cs.getTemperature();
    }
    
    public void update(Observable obj, Object arg) {
     //   chamber2Table.fireTableDataChanged();
       // ConcreteSubject cs = (ConcreteSubject)obj;
         //   if (!name.equals(cs.getName())) {
           //     name = cs.getName();
             //   System.out.println("NameObserver: Name changed to " + name);
            //}
       // }
    }
}
