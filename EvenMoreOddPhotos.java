import java.io.*;
import java.util.*;

/**
 * EvenMoreOddPhotos
 */
public class EvenMoreOddPhotos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int odd = 0, even = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int toAdd = Integer.parseInt(st.nextToken());
            if (toAdd % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        if (even > odd) {
            pw.println(2*odd+1);
        } else if (even == odd) {
            pw.println(2*odd);
        } else {
            while (even < odd) {
                odd -= 2;
                even++;
            }
            if (odd == even - 2) {
                pw.println(2*odd+1);
            } else {
                pw.println(even+odd);
            }
        }

        br.close();
        pw.close();
    }    
}