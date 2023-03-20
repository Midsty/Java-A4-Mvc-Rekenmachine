import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controller {

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    Model model;

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
