package ru.stqa.geometry.figures;

import java.lang.Math;

public record Triangle(double a, double b, double c) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 &&
                Double.compare(this.b, triangle.b) == 0 &&
                Double.compare(this.c, triangle.c) == 0) ||
                (Double.compare(this.a, triangle.b) == 0 &&
                Double.compare(this.b, triangle.c) == 0 &&
                Double.compare(this.c, triangle.a) == 0)||
                (Double.compare(this.a, triangle.c) == 0 &&
                Double.compare(this.b, triangle.a) == 0 &&
                Double.compare(this.c, triangle.b) == 0)||
                (Double.compare(this.a, triangle.b) == 0 &&
                Double.compare(this.b, triangle.a) == 0 &&
                Double.compare(this.c, triangle.c) == 0)||
                (Double.compare(this.a, triangle.c) == 0 &&
                Double.compare(this.b, triangle.b) == 0 &&
                Double.compare(this.c, triangle.a) == 0)||
                (Double.compare(this.a, triangle.a) == 0 &&
                Double.compare(this.b, triangle.c) == 0 &&
                Double.compare(this.c, triangle.b) == 0);


    }
    @Override
    public int hashCode() {
        return 1;
    }


    public static void printTriangleArea(double a, double b, double c) {
        System.out.println("Площадь треугольника со сторонами " + a + " , " + b + "  " + c + " = " + (TriangleArea(a, b, c)));

    }
    public static void printTrianglePerimeter(double a, double b, double c) {
        System.out.println("Периметр треугольника со сторонами " + a + " , " + b + "  " + c + " = " + (TrianglePerimeter(a, b, c)));

    }

    public Triangle(double a, double b, double c) {
        if (a<0 || b<0 || c<0 ){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a+b<=c || a+c<=b || c+b<=a ){
            throw new IllegalArgumentException("Triangle inequality violated");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public static double TriangleArea (double a, double b, double c){
        double p = (a + b + c)/2;
        return Math.sqrt(p * ( p - a ) * ( p - b ) * ( p - c ));

    }
    public static double TrianglePerimeter (double a, double b, double c){
        double p = a + b + c;
        return p;

    }
}
