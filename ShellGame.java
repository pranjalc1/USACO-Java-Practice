import java.io.*;
import java.util.*;

/**
 * ShellGame
 */

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] rounds = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rounds[i][0] = Integer.parseInt(st.nextToken());
            rounds[i][1] = Integer.parseInt(st.nextToken());
            rounds[i][2] = Integer.parseInt(st.nextToken());
        }

        int maxCorrect = 0;
        for (int init = 1; init <= 3; init++) {
            int correct = 0;
            int pos = init;
            for (int round = 0; round < N; round++) {
                if (pos == rounds[round][0]) {
                    pos = rounds[round][1];
                } else if (pos == rounds[round][1]) {
                    pos = rounds[round][0];
                }

                if (pos == rounds[round][2]) {
                    correct++;
                }
            }

            if (correct > maxCorrect) {
                maxCorrect = correct;
            }
        }

        pw.println(maxCorrect);

        br.close();
        pw.close();
    }
}