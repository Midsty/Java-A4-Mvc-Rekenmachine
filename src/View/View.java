package View;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class  View extends JFrame implements PropertyChangeListener {
    public JTextField jtValue1;
    public JTextField jtResult;
    public Controller controller;
    public JPanel knopPanel;
    public  JButton knopText;

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
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0.2;
        this.add(panel);
        jtValue1 = new JTextField("10");
       // panel.add(jtValue1); vakjes uitgezet
        jtResult = new JTextField("uitkomst");
        panel.add(jtResult, c); //vakjes uitgezet\

//        jtResult.setPreferredSize(new Dimension(150,30));

        setResizable(false);

        knopPanel = new JPanel(new GridLayout(4,5, 5,5));
        knopPanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        c.gridy = 1;
        c.weighty = 1;
        panel.add(knopPanel,c );

        // Printen jbuttons met text symbolen.

        for(int bl = 0; bl < BUTTON_LABELS.length; bl++){
            if(BUTTON_LABELS[bl] == ' '){
                knopPanel.add(new JLabel());
            } else {
                knopPanel.add(new JButton("" + BUTTON_LABELS[bl]));
            }
        }
//        for (int i = 0; i < calculator.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                // Maken JButton objecten en vul met waarde.
//                if (j == calculator[i].length) {
//                    knopPanel.add(new JLabel());
//                } else {
//                    // Maak nieuw JButton object en stop text in de jbuttons.
//                    knopText = new JButton(calculator[i][j]);
//
//                    // Voegen jbuttons aan JPanel.
//                    knopPanel.add(knopText);
//
//                    // Voeg ActionListener aan knop objecten.
////                    knopText.addActionListener(new ActionListener() {
////                        @Override
////                        public void actionPerformed(ActionEvent e) {
////                            // Get text uit button.
////                            knopText = (JButton) e.getSource();
////
////                            // Stuur text naar controller method.
////                            controller.addClickText(knopText.getText());
////                        }
////                    });
//                }
//            }
//        }
//        pack();
    }



    //Bereken knop
//        beq1 = new JButton("=");
//
//        //Plus min keer
//        ba = new JButton("+");
//        bs = new JButton("-");
//        bd = new JButton("/");
//        bm = new JButton("*");
//        beq = new JButton("C");
//
//        // display schermpje
//        display = new JTextField("zonder text is dit veld heel klein");
//
//        //Laat de knoppen zien
//        {
//            panel.add(b0);
//            panel.add(b1);
//            panel.add(b2);
//            panel.add(bd);
//        }
//
//        {
//        panel.add(b3);
//        panel.add(b4);
//        panel.add(b5);
//        panel.add(bm);
//        }
//
//        {
//            panel.add(b6);
//            panel.add(b7);
//            panel.add(b8);
//            panel.add(bs);
//        }
//
//        {
//            panel.add(b9);
//            panel.add(beq1);
//            panel.add(beq);
//            panel.add(ba);
//        }
//
//        {
//            panel.add(display);
//        }
//
//
//
//
//        //Achtergrond van de knoppen
//        panel.setBackground(Color.blue);

        /*JButton jButton = new JButton("Bereken");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalc();

            }
        });



        panel.add(jButton);

         */
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setVisible(true);
//
//    }

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
