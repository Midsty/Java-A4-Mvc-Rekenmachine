import Controllers.Controller;
import Model.Model;
import View.View;

import javax.swing.*;

public class Runner {

    public static void main(String[] args) {

        Model model = new Model();

        Controller controller = new Controller();
        controller.setModel(model);

        View view = new View();
        view.setController(controller);
        view.doCalc();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(250, 300);
        view.setLocationRelativeTo(null);
        view.setTitle("Rekenmachine");
        view.setVisible(true);



 //         char operator;
//         double num1,num2;
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Vul een optie in (+,-,*,/)");
//        operator = input.next().charAt(0);
//
//        System.out.println("Voer twee getallen in");
//        num1 = input.nextDouble();
//        num2 = input.nextDouble();
//
//        input.close();
//
//        switch (operator ) {
//            case '+':
//                System.out.printf("%.2f + %.2f = %.2f", num2,num2,(num1+num2));
//                break;
//
//            case '-':
//                System.out.printf("%.2f * %.2f = %.2f", num1,num2,(num1-num2));
//                break;
//
//            case '*':
//                System.out.printf("%.2f * %.2f = %.2f", num1,num2,(num1*num2));
//                break;
//
//            case '/':
//                if(num2 != 0)
//                    System.out.printf("%.2f / %.2f = %.2f", num1,num2,(num1/num2));
//                else
//                    System.out.println("Delen met null");
//                break;
//
//            default:
//                System.out.printf("%c is niet geldige optie",operator);
//        }
    }
}