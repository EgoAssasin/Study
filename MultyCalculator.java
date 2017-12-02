import java.util.Scanner;
/**
 * Created by Egor on 02.12.2017.
 */
public class MultyCalculator {
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
            System.out.println("Вы допустили ошибку, ИСПОЛЬЗУЙТЕ ЗАПЯТУЮ!!! при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble();
        }
        return num;
    }

    /**
     * Метод считывает операцию введённую с консори и проверяет на правильность ввода
     * @return
     */
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    /**
     * Метод производит расчёт двух чисел num1, num2 операции
     * @param num1 первая переменная
     * @param num2 вторая переменная
     * @param operation операция которая должна быть произведена
     * @return
     */

    public static Double calc(Double num1, Double num2, char operation){
        Double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }

    /**
     * Точка входа в программу
     * @param args
     */
    public static void main(String args[]) {
        Double num1=getDouble(); //Вводим первую переменную
        Double num2=getDouble(); //Вводим вторую переменную
        char operation = getOperation(); //Вводим операцию, которую нужно произвести над переменными
        Double result=(double)Math.round(calc(num1,num2,operation)*10000)/10000; //Получаем результат и округляем до 4-ёх знаков после запятой
        //Double result=(double)Math.round(calc(num1,num2));
        System.out.println("Результат операции: "+result);
    }
}

