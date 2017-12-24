package Lesson_4.Calculator;

/**
 * Created by Egor on 24.12.2017.
 * Создаю User-define Exeption
 */
public class myExeption extends Exception{
    private double result;

    public myExeption(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}
