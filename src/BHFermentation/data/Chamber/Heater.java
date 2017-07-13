/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.data.Chamber;

import BHFermentation.data.Component;

/**
 *
 * @author Mark
 */
public class Heater extends Component {
    private int dim;
    
    public void setDim(int dim){
        this.dim = dim;
    }
    
    public int getDim(){
        return this.dim;
    }
}
