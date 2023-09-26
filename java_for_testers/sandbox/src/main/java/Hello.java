package sandbox.src.main.java;

import java.io.File;
import java.sql.SQLOutput;

public class Hello {
    public static void main(String[] args) {

        var x = 1;
        var y = 0;
        var z = x/y;

        System.out.println(z);

        System.out.println("Hello world");


        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

    }
}