package Lesson3;

import java.util.Scanner;

/**
 * Created by out-spiridonov-es on 18.12.2017.
 * Класс ввода данных с клавиатуры
 */
public class Input {

    static Scanner str = new Scanner(System.in);
    /**
     * Ввод числа типа Double
     */
    public static double doubleNum() {
        double num=0;
        if (str.hasNextDouble()){
            num=str.nextDouble();
        }
        else
        {
            System.out.print("Ошибка! Введите число! ");
            str.next();
            num = doubleNum();

        }
        return num;
    }

    /**
     * ввод операции +,-,*,/
     */
    public static char operation() {
        char ch = str.next().charAt(0);
        if ((ch!='+')&&((ch!='-'))&&(ch!='*')&&(ch!='/')) {
            System.out.print("Можно только: +,-,*,/  ");
            ch=operation();
        }
        return ch;
    }
}
