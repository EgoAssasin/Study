import java.util.Scanner;
/**
 * Created by Egor on 02.12.2017.
 */


public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Метод считывания числа с консоли и проверки на правильность ввода
     * @return возвращает число типа Double
     */
    public static Double getDouble(){
        System.out.println("Введите дробное число(дробь вводится через запятую):");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
            System.out.println("Вы ввели: "+num);
        } else {
            System.out.println("Вы допустили ошибку, ИСПОЛЬЗУЙТЕ ЗАПЯТУЮ!!! при вводе числа и НЕ ВВОДИТЕ БУКВЫ!!! Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble();
        }
        return num;
    }

    /**
     * Метод расчитывает сумму двух чисел num1 и num2 поданных на вход
     * @param num1 первое число
     * @param num2 второе число
     * @return
     */
    public static Double calc(Double num1, Double num2){
        Double result =num1+ num2;
        return result;
    }


    public static void main(String args[]) {
        /**
         * Точка входа в программу
         */
        Double num1=getDouble();//Вводим первую переменную
        Double num2=getDouble();//Вводим вторую переменную
        Double result=(double)Math.round(calc(num1,num2)*10000)/10000; //Получаем результат и округляем до 4-ёх знаков после запятой
        System.out.println("Результат операции: "+result);
    }
}
