package sandbox.src.main.java.ru.stqa.geometry.figures;
import java.lang.Math;

public record Triangle(double a, double b, double c) {

    public static void printTriangleArea(double a, double b, double c) {
        System.out.println("Площадь треугольника со сторонами " + a + " , " + b + "  " + c + " = " + (TriangleArea(a, b, c)));

    }
    public static void printTrianglePerimeter(double a, double b, double c) {
        System.out.println("Периметр треугольника со сторонами " + a + " , " + b + "  " + c + " = " + (TrianglePerimeter(a, b, c)));

    }


    public static double TriangleArea (double a, double b, double c){
        double p = (a + b + c)/2;
        return Math.sqrt(p * ( p - a ) * ( p - b ) * ( p - c ));

    }
    public static double TrianglePerimeter (double a, double b, double c){
        double p = (a + b + c)/2;
        return p;

    }
}
