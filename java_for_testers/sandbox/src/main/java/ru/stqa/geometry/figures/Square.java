package sandbox.src.main.java.ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double a) {
        System.out.println("Площадь квадрата со стороной " + a + " = " + squareArea(a));

    }

    private static double squareArea(double a) {
        return a * a;
    }
}
