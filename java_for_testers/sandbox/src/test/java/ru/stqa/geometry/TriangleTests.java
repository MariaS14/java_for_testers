package sandbox.src.main.java.ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Triangle;

public class TriangleTests {

        @Test

        void cannotCreateTriangleWithNegativeSide () {

            try {
                new ru.stqa.geometry.figures.Triangle(-13.0, 5.0,12.0 );
                Assertions.fail();
            } catch (IllegalArgumentException exception) {
                //ОК
            }

        }
    @Test
    void testEquality() {
        var t1 = new Triangle(5.0, 4.0, 12.0);
        var t2 = new Triangle(5.0, 4.0, 12.0);
        Assertions.assertEquals(t1, t2);
    }



    @Test
    void testEquality2() {
        var t3 = new Triangle(5.0,4.0,12.0);
        var t4 = new Triangle(4.0,5.0,12.0);
        Assertions.assertEquals(t3, t4);
    }
    }
