package View;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class  View extends JFrame implements PropertyChangeListener {
    public JTextField jtValue1;
    public JTextField jtResult;
    public Controller controller;
    public JPanel knopPanel;
    public  JButton knopText;

    public  Font font1;

    private static final char[] BUTTON_LABELS = {
            '1','2','3','+',' ',
            '4','5','6','-',' ',
            '7','8','9','*',' ',
            '0','.','/','C','='
    };

    public View() {

        this.setSize(600, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        this.add(panel);
        jtResult = new JTextField("uitkomst");
        panel.add(jtResult, c);
        jtValue1 = new JTextField("10");

        //JTextField.setFont(new Font("Consolas",Font,Font.PLAIN,35));


       /* De font van de tekst veld
        TextField.setFont(Font.font("Serif", FontWeight.BOLD,13));
*/

        // panel.add(jtValue1); vakjes uitgezet


//        jtResult.setPreferredSize(new Dimension(150,30));

        setResizable(false);

        knopPanel = new JPanel(new GridLayout(4, 5, 5, 5));
        knopPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        c.gridy = 1;
        c.weighty = 1;
        panel.add(knopPanel, c);

        // Printen jbuttons met text symbolen.

        ActionListener knopHandler = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ) {
                JButton actionButton = (JButton)e.getSource();
                //Haalt de uitkomst op van de controller
                jtResult.setText(controller.processInput(actionButton.getText()));
            }
        };

        for (int bl = 0; bl < BUTTON_LABELS.length; bl++) {
            if (BUTTON_LABELS[bl] == ' ') {
                knopPanel.add(new JLabel());
            } else {
                JButton b = new JButton("" + BUTTON_LABELS[bl]);
                b.addActionListener(knopHandler);
                knopPanel.add(b);
            }
        }



    }

    public void setController(Controller controller) {
        this.controller = controller;
        controller.setPropertyChangeListener(this);
    }

   public void doCalc(){
       controller.doCalc(jtValue1.getText(),"150",'+');

    }

   @Override
    public void propertyChange(PropertyChangeEvent evt) {
       int result = (int) evt.getNewValue();
        jtResult.setText(Integer.toString(result));

       font1 = new Font("consola", Font.PLAIN, 30);

       jtResult.setFont(font1);

       jtResult.setEditable(false);
    }


}

