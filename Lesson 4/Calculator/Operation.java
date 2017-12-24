package Lesson_4.Calculator;

/**
 * Абстрактный класс по которому далее буду создавать дочерние классы "Сложение-Sum","Вычитание-Minus","Умножение-Mult","Деление-Delenie"
 */
abstract class Operation {
    abstract double getResult(double a, double b) throws myExeption;
}
