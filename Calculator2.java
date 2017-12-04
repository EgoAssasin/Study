/**
 * Created by out-spiridonov-es on 04.12.2017.
 */

import java.util.Scanner;

class Input {
    static Scanner str = new Scanner(System.in);
    static double doubleNum() {
        // Scanner str = new Scanner(System.in);
        double num=0;
        if (str.hasNextDouble()){
            num=str.nextDouble();
            // System.out.println("Введено число: " + num);
        }
        else
        {
            System.out.print("Ошибка! Введите число(дробная часть через запятую)! ");
            str.next();
            num = doubleNum();

        }
        return num;
    }
    static char operation() {
        // Scanner str = new Scanner(System.in);
        char ch = str.next().charAt(0);
        if ((ch!='+')&&((ch!='-'))&&(ch!='*')&&(ch!='/')) {
            System.out.print("Можно только: +,-,*,/  ");
            ch=operation();
        }
       /* else{
            System.out.println("Вы ввели операцию: " + ch);
        }*/
        return ch;
    }

    static double result(double value1,double value2,char operation) {
        double res;
        switch (operation){
            case '+': res=value1+value2; break;
            case '-': res=value1-value2; break;
            case '*': res=value1*value2; break;
            case '/': res=value1/value2; break;
            default: res=value1+value2; break;
        }
        return res;
    }
}

public class Calculator2 {
    public static void main(String args[]){
        System.out.print("Введите 1-ое число: ");
        double num1 = Input.doubleNum();
        System.out.print("Введите операцию +,-,*,/: ");
        char oper = Input.operation();
        System.out.print("Введите 2-ое число: ");
        double num2 = Input.doubleNum();
        System.out.println("------------ИТОГО---------------");
        System.out.printf(num1 + " " + oper + " " + num2 + " = "+ "%.4f",Input.result(num1,num2,oper));
    }
}

