package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class  View extends JFrame implements PropertyChangeListener {
    JTextField jtValue1;
    JTextField jtResult;
    Controller controller;

    public View() {

        this.setSize(400, 300);
        JPanel panel = new JPanel();
        this.add(panel);
        jtValue1 = new JTextField("10");
       // panel.add(jtValue1); vakjes uitgezet
        jtResult = new JTextField("result");
       // panel.add(jtResult); vakjes uitgezet

        //Maakt de knoppen aan
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        JTextField display;

        //De nummers van de rekenmachine
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        //Bereken knop
        beq1 = new JButton("=");

        //Plus min keer
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        // display schermpje
        display = new JTextField("zonder text is dit veld heel klein");

        //Laat de knoppen zien
        {
            panel.add(b0);
            panel.add(b1);
            panel.add(b2);
            panel.add(bd);
        }

        {
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(bm);
        }
        {
            panel.add(b6);
            panel.add(b7);
            panel.add(b8);
            panel.add(bs);
        }
        {
            panel.add(b9);
            panel.add(beq1);
            panel.add(beq);
            panel.add(ba);
        }
        {
            panel.add(display);
        }




        //Achtergrond van de knoppen
        panel.setBackground(Color.blue);

        /*JButton jButton = new JButton("Bereken");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalc();

            }
        });



        panel.add(jButton);

         */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

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
    }
}
