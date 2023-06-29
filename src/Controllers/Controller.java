package Controllers;

import Model.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controller {

    //Properties voor de uitkomst
    Model model;
    //Symbolen
    //public String sN0,N1, N2;

    PropertyChangeSupport pcs;

    public Controller() {
     pcs = new PropertyChangeSupport(this);

    }

    //Stuurt de input weer terug naar de Model
    public String processInput(String input){
        model.addInput(input.charAt(0));
       return model.getInput();
    }


    //Getters en setters voor de value 1,2 en operators
    public void doCalc(String value1, String value2, char operator){
        model.setValue1(Integer.parseInt(value1));
        model.setValue2(Integer.parseInt(value2));
        model.setOperator(operator);

        int result = model.calculate();

        pcs.firePropertyChange("result", 0, result);

    }

    public void setPropertyChangeListener(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
