package CleanCode.Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example1 {

    private static List readLines_bad(String fileName) {
        String line;
        ArrayList file = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null)
                file.add(line);
            in.close();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
        return file;
    }

    // Always know why you are catching an exception
    // The catch block here does nothing useful. In fact, it hides useful information if the program were to crash.
    private static List readLines_good(String fileName) throws IOException {
        String line;
        // 1. Never declare implementation types
        // problems with this: ArrayList is longer, and you have to do a lot of work if you want to change what list implementation you are using.

        // 2. Use descriptive variable names. Lines is clearer than file
        List lines = new ArrayList();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        while ((line = in.readLine()) != null)
            lines.add(line);
        in.close();

        return lines;
    }
}
