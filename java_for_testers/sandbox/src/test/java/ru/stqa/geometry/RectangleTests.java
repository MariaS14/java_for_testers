package ru.stqa.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {
    @Test
    void cannotCreateRectangleWithNegativeSide () {

        try {
            new ru.stqa.geometry.figures.Rectangle(-5.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ОК
        }
    }
}

