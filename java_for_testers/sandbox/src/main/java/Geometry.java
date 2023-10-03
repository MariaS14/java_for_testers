import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Triangle;
import sandbox.src.main.java.ru.stqa.geometry.figures.Square;

public class Geometry {
  public static void main(String[] args) {
      Square.printSquareArea(new Square(7.0));
      Square.printSquareArea(new Square(5.0));
      Square.printSquareArea(new Square(3.0));
      Rectangle.printRectangleArea(3.0, 5.0);
      Triangle.printTriangleArea(13.0, 5.0, 12.0);

  }

}
