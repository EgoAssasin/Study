package Lesson3;

/**
 * Абстрактный класс по которому далее буду создавать дочерние классы "Сложение-Sum","Вычитание-Minus","Умножение-Mult","Деление-Delenie"
 */
abstract class Operation {
    double getResult(double a,double b){
     return a+b;
    }
}
