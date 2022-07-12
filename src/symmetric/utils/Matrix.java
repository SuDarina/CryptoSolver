package symmetric.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    public static String[][] performToArr(File file) {
        int strAmount = 0;
        try (Scanner scr = new Scanner(file)) {
            while (scr.hasNextLine()) {
                scr.nextLine();
                strAmount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[][] res = new String[strAmount][strAmount];
        try(Scanner scr = new Scanner(file)) {
            for (int i = 0; i < strAmount; i++) {
                String line = scr.nextLine();
                res[i] = line.split(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args)  {
        System.out.println(Arrays.deepToString(Matrix.performToArr
                (new File("src/symmetric/utils/sources/table.txt").getAbsoluteFile())));
    }
}
