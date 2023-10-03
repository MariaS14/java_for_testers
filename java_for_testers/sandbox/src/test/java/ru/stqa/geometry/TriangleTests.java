package sandbox.src.main.java.ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    }
