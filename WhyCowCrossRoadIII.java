import java.io.*;
import java.util.*;

/**
 * WhyCowCrossRoadIII
 */
public class WhyCowCrossRoadIII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] timeAndDuration = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeAndDuration[i][0] = Integer.parseInt(st.nextToken());
            timeAndDuration[i][1] = Integer.parseInt(st.nextToken());
        }

        // Sort array using lambda function
        Arrays.sort(timeAndDuration, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(timeAndDuration);

        int cow = 0;
        int timeNow = 0;

        while (cow < N) {
            timeNow = Integer.max(timeNow, timeAndDuration[cow][0]);
            timeNow += timeAndDuration[cow][1];
            cow++;
        }

        pw.println(timeNow);

        br.close();
        pw.close();
    }
}