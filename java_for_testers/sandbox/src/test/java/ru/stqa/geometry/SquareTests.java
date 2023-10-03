package ru.stqa.geometry;

import org.junit.jupiter.api.Test;
import sandbox.src.main.java.ru.stqa.geometry.figures.Square;
import org.junit.jupiter.api.Assertions;
import ru.stqa.geometry.figures.Triangle;


public class SquareTests {

    @Test
    //void ничего не возвращает функции
    //public функция глобальная

    public void canCalculateArea() {
        var s = new Square(4.0);//для переменной мы можем использовать ключевое слово var, тип этой переменной java определяет автоматически
        double result = s.area();
        //Assertions.assertEquals(25.0, Square.area(5.0));
        if (!(result == 25.0)) {
            throw new AssertionError(String.format("Expected %f, actual %f", 25.0, result));
        }
    }
        public static void printSquareArea(double side) {
            String text = String.format("Площадь квадртата со сторон");
        }


        @Test
        public void canCalculatePerimeter () {
            Assertions.assertEquals(20.0, new Square(5.0).perimeter());

        }

        @Test
        public void canCalculateTrianglePerimeter () {
            double result = Triangle.TrianglePerimeter(13, 5, 12);
            Assertions.assertEquals(15.0, result);
        }
        @Test
        public void canCalculateTriangleArea () {
            double result = Triangle.TriangleArea(13, 5, 12);
            Assertions.assertEquals(30.0, result);
        }


        @Test
        void cannotCreateSquareWithNegativeSide () {

            try {
                new Square(-5.0);
                Assertions.fail();
            } catch (IllegalArgumentException exception) {
                //ОК
            }
        }
    }
