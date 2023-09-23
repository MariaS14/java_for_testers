package sandbox.src.main.java.ru.stqa.geometry;

import sandbox.src.main.java.ru.stqa.geometry.figures.Rectangle;
import sandbox.src.main.java.ru.stqa.geometry.figures.Square;
import sandbox.src.main.java.ru.stqa.geometry.figures.Triangle;

public class Geometry {
  public static void main(String[] args) {
      Square.printSquareArea(new Square(7.0));
      Square.printSquareArea(new Square(5.0));
      Square.printSquareArea(new Square(3.0));
      Rectangle.printRectangleArea(3.0, 5.0);
      Triangle.printTriangleArea(13.0, 5.0, 12.0);

  }

}
