/**
 * Created by out-spiridonov-es on 05.12.2017.
 */
import java.util.Scanner;

class Vocabulary {
    String[] mass;

    Vocabulary(int length){
        mass = new String[length];
    }
}

class Input2 {
    static Scanner str = new Scanner(System.in);
    static byte byteNum() {
        byte num=0;
        if (str.hasNextByte()){
            num=str.nextByte();
        }
        else
        {
            System.out.print("Ошибка! Введите число! ");
            str.next();
            num = byteNum();

        }
        return num;
    }
    static String str() {
        String stroka = str.next().toString();
        return stroka;
    }
}



public class Slovo {
    public static void main(String args[]){
        System.out.print("Введите кол-во слов: ");
        byte num1 = Input2.byteNum();
        while (num1<=0){
            System.out.print("Ошибка! Введено отрицательное число!Введите число: ");
            num1 = Input2.byteNum();
        }
        Vocabulary pole = new Vocabulary(num1);
        String slovoIn;
        for (byte i=0;i<num1;i++){
            System.out.print("Введите " + (i+1) + "-e слово: ");
            slovoIn = Input2.str();
            pole.mass[i] = slovoIn;
        }
        slovoIn = pole.mass[0];
        for (byte i=0;i<num1;i++){
            if (slovoIn.length()<pole.mass[i].length()) slovoIn=pole.mass[i];
            //System.out.print(pole.mass[i] + "|");
        }
        System.out.print("Самое длинное слово - " + slovoIn);
    }
}
