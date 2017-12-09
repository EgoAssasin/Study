/**
 * Created by out-spiridonov-es on 08.12.2017.
 */
import java.util.Scanner;
class Vocabulary2 {
    String[] mass;

    Vocabulary2(int length){
        mass = new String[length];
    }
}

class Input3 {
    static Scanner str = new Scanner(System.in);
    static double doubleNum() {
        double num=0;
        if (str.hasNextDouble()){
            num=str.nextDouble();
        }
        else
        {
            System.out.print("Ошибка! Введите число!(дробная часть через \",\")");
            str.next();
            num = doubleNum();

        }
        return num;
    }
    static char operation() {
        char ch = str.next().charAt(0);
        if ((ch!='+')&&((ch!='-'))&&(ch!='*')&&(ch!='/')) {
            System.out.print("Можно только: +,-,*,/  ");
            ch=operation();
        }
        return ch;
    }
    static byte byteNum() {
        byte num=0;
        if (str.hasNextByte()){
            num=str.nextByte();
        }
        else
        {
            System.out.print("Ошибка! Введите число!(дробная часть через \",\") ");
            str.next();
            num = byteNum();

        }
        return num;
    }
    static String str() {
        String stroka = str.next().toString();
        return stroka;
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
class calc{
    static void run(){
        System.out.print("Введите 1-ое число(дробная часть через \",\"): ");
        double num1 = Input3.doubleNum();
        System.out.print("Введите арифметическую операцию +,-,*,/: ");
        char oper = Input3.operation();
        System.out.print("Введите 2-ое число(дробная часть через \",\"): ");
        double num2 = Input3.doubleNum();
        System.out.println("------------ИТОГО------------");
        System.out.printf("%.4f %s %.4f %s %.4f",num1,oper,num2," = ",Input3.result(num1,num2,oper));
    }
}
class slovo{
    static void run(){
        System.out.print("\nВведите кол-во слов: ");
        byte num1 = Input3.byteNum();
        while (num1<=0){
            System.out.print("Ошибка! Введено отрицательное число!Введите число: ");
            num1 = Input3.byteNum();
        }
        Vocabulary2 pole = new Vocabulary2(num1);
        String slovoIn;
        for (byte i=0;i<num1;i++){
            System.out.print("Введите " + (i+1) + "-e слово: ");
            slovoIn = Input3.str();
            pole.mass[i] = slovoIn;
        }
        slovoIn = pole.mass[0];
        for (byte i=0;i<num1;i++){
            if (slovoIn.length()<pole.mass[i].length()) slovoIn=pole.mass[i];
        }
        System.out.print("Самое длинное слово - " + slovoIn);
    }
}
public class CalcSlovo {
    public static void main(String args[]){
        System.out.println("1 - Калькулятор\n2 - Поиск максимального слова в массиве");
        String choice="";
        while (!choice.equals("1")&&(!choice.equals("2"))){
            System.out.println("Введите 1 или 2:");
            choice = Input3.str();
            if (choice.equals("1")) {System.out.println("--------Калькулятор--------");calc.run();}
            if (choice.equals("2")) {System.out.println("--------Поиск максимального слова в массиве--------");slovo.run();}
        }
    }
}
