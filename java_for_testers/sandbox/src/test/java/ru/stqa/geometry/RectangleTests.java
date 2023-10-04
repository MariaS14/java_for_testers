package ru.stqa.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.geometry.figures.Rectangle;

public class RectangleTests {
    @Test
    void cannotCreateRectangleWithNegativeSide() {

        try {
            new ru.stqa.geometry.figures.Rectangle(-5.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }
    }

    @Test
    void testEquality() {
        var r1 = new Rectangle(5.0, 4.0);
        var r2 = new Rectangle(5.0, 4.0);
        Assertions.assertEquals(r1, r2);
    }



        @Test
        void testEquality2() {
        var r1 = new Rectangle(5.0,4.0);
        var r2 = new Rectangle(4.0,5.0);
        Assertions.assertEquals(r1, r2);
    }
    }


