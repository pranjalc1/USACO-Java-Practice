import java.io.*;
import java.util.*;

/**
 * FencePainting
 */

public class FencePainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (b <= c || a >= d) {
            pw.println(b+d-a-c);
        } else if (b >= d && a <= c) {
            pw.println(b-a);
        } else if (b <= d && a >= c) {
            pw.println(d-c);
        } else if (a <= c && c <= b && b <= d) {
            pw.println(d-a);
        } else if (c <= a && a <= d && d <= b) {
            pw.println(b-c);
        }

        br.close();
        pw.close();
    }
}