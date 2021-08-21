import java.io.*;
import java.util.Scanner;

/**
 * FencePainting
 */
public class FencePainting {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("paint.in");
        Scanner scnr = new Scanner(fileIn);

        String[][] array = new String[2][2];
        int lineNum = 0;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            String[] lineSplit = line.split(" ", 0);
            array[lineNum] = lineSplit;
        }

        scnr.close();

        int a = Integer.parseInt(array[0][0]);
        int b = Integer.parseInt(array[0][1]);
        int c = Integer.parseInt(array[1][0]);
        int d = Integer.parseInt(array[1][1]);

        FileWriter fileOut = new FileWriter("paint.out");
        if (b < c | a > d) {
            fileOut.write((b+c-a-d) + "\n");
        } else if (b > d & a < c) {
            fileOut.write((b-a) + "\n");
        } else if (b < d & a > c) {
            fileOut.write((d-c) + "\n");
        } else if ((c < b & b < d) & a < c) {
            fileOut.write((d-a) + "\n");
        } else if ((a < d & d < b) & c < a) {
            fileOut.write((b-c) + "\n");
        }

        fileOut.close();
    }
}