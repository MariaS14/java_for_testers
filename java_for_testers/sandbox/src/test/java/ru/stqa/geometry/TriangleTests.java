package sandbox.src.main.java.ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Triangle;

public class TriangleTests {

    @Test
    void cannotCreateTriangleWithNegativeSide() {

        try {
            new ru.stqa.geometry.figures.Triangle(-13.0, 5.0, 12.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }

    }

    @Test// проверяет равенство треугольников где стороны передаются в разном порядке
    void testEquality() {
        var triangle1 = new Triangle(13.0, 5.0, 12.0);
        var triangle2 = new Triangle(12.0, 13.0, 5.0);
        Assertions.assertEquals(triangle1,triangle2);
    }
    @Test
    void testEquality1() {
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(a, c, b);
        Assertions.assertEquals(triangle, triangle1);
    }
    @Test //сравнивает два треугольника на равенство
    void testPassEquality() {
        var tr4 = new Triangle(13.0, 5.0, 12.0);
        var tr5 = new Triangle(13.0, 5.0, 12.0);
        Assertions.assertTrue(tr4.equals(tr5));
    }
}

