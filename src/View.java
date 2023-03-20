import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class  View extends JFrame implements PropertyChangeListener {
    JTextField jtValue1;
    JTextField jtResult;
    Controller controller;

    public View(){

        this.setSize(400, 300);
        JPanel panel = new JPanel();
        this.add(panel);
        jtValue1 = new JTextField("10");
        panel.add(jtValue1);
        jtResult =  new JTextField("result");
        panel.add(jtResult);

        JButton jButton = new JButton("Bereken");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalc();

            }
        });

        panel.add(jButton);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
        controller.setPropertyChangeListener(this);
    }

    public void doCalc(){
        controller.doCalc(jtValue1.getText(),"15",'+');

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int result = (int) evt.getNewValue();
        jtResult.setText(Integer.toString(result));
    }
}
