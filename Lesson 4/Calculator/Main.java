package Lesson_4.Calculator;

/**
 * Created by out-spiridonov-es on 18.12.2017.
 * Запуск программы
 */
public class Main {
    public static void main(String args[]){
        try {
            System.out.print("Введите 1-ое число: ");
            double a = Input.doubleNum();
            System.out.print("Введите арифметическую операцию +,-,*,/: ");
            char oper = Input.operation();
            System.out.print("Введите 2-ое число: ");
            double b = Input.doubleNum();
            System.out.println("------------ИТОГО------------");
            Operation calc;
            switch (oper){
                case '+': calc = new Sum(); break;
                case '-': calc = new Minus(); break;
                case '*': calc = new Mult(); break;
                case '/': calc = new Delenie(); break;
                default: calc = new Sum(); break;
            }
            System.out.printf("%.4f %s %.4f %s %.4f",a,oper,b," = ",calc.getResult(a,b));
            System.out.println();
        }
        catch (myExeption e){
            System.out.println("Ошибка деления на ноль! Результат: " + e.getResult());
            e.printStackTrace();
        }

    }
}
