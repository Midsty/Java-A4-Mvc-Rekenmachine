package Model;

public class Model {

    int value1 =0;
    int value2 =0;

    String input = "";

    char operator = '+';


    public void addInput(char input){
        if(Character.isDigit(input)){
            this.input += input;
        } else {
            if(input == '='){
                value2 = Integer.parseInt(this.input);
                this.input = "" + calculate();

            } else {
                value1 = Integer.parseInt(this.input);
                this.input = "";
                operator = input;
            }
        }
    }

    public String getInput(){
        return input;
    }
    public int calculate(){

        switch (operator)
        {
            case '+': return value1 + value2;
            case '-': return value1 - value2;
            case '*': return value1 * value2;
            case '/':  return value1 / value2;
        }

        return 0;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
