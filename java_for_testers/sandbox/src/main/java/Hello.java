import java.io.File;
import java.sql.SQLOutput;

public class Hello {

    public static void main(String[] args) {

        System.out.println("Hello, world!");

        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());


        System.out.println(new File("").getAbsolutePath());
    }
}

       /* var x = 1;
        var y = 0;
        if (y==0) {
            System.out.println("Division by zero is not allowed");
        } else {
            var z = divide(x, y);
            System.out.println(z);
            System.out.println("Hello world");
        }
    }


    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}*/