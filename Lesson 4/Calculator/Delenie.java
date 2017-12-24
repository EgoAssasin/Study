package Lesson_4.Calculator;

/**
 * Класс "Деление-Delenie"
 */
public class Delenie extends Operation{
    @Override
    double getResult(double a, double b) throws myExeption{
        if (b!=0) return a/b;
        else {
            throw new myExeption(0);//Передаю результат исключения
        }
    }
}
