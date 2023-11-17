import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Triangle;
import sandbox.src.main.java.ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100));
        var squares = Stream.generate(randomSquare).limit(5);


        squares.peek(Square::printArea).forEach(Square::printPerimeter);


    };
    }


//squares.peek(Square::printArea).peekSquare::printArea);


//Rectangle.printRectangleArea(3.0, 5.0);
//Triangle.printTriangleArea(13.0, 5.0, 12.0);
 /*for (Square square : squares) {
            //Square.printSquareArea(square);

             Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));
Consumer<Square> print = Square::printSquareArea;
        squares.forEach(print);
            Consumer<Square> print = square -> {
                Square.printArea(square);
                Square.printPerimeter(square);
            };
            squares.forEach(print);
        }*/