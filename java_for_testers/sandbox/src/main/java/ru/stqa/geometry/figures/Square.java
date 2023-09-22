package sandbox.src.main.java.ru.stqa.geometry.figures;

import javax.swing.*;

public record Square(double side) {

    //для ключевого свойства объекта мы можем использовать только тип, не можем использовать var

   // private double side;//для ключевого свойства объекта должны ЯВНО указывать тип

    //public Square(double side) {
        //this.side = side;
        // первое side - свойство объекта, второе параметры функции


    //для описания свойства функции модификатор public или privite(свойство доступно ТОЛЬКО внутри класса)
    //если не укажем ничего, свойство будет доступно всем классам находящимся в пакете
    public static void printSquareArea(Square s) {
        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.area());
        System.out.println();
    }
    // свойство static - значит функция должна вызываться в классе(просто функция, все данные передаются через параметры)
    public static double area(double a) {
        return a * a;
    }

    public double area() {
        //если нет ключевого static нет, то функция должна вызываться в объекте в котором она была вызвана
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
