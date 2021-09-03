import java.io.*;
import java.util.*;

/**
 * Hoofball2
 * Solution inspired by official solution
 */
public class Hoofball2 {
    
    public static int checkForSources(int[] passPositions) {
        int N = passPositions.length;
        int sources = 0;
        if (passPositions.length == 1) {
            sources = 1;
        } else {
            int[] occCount = new int[N];
            for (int pos = 0; pos < N; pos++) {
                for (int passPos : passPositions) {
                    if (passPos == pos) {
                        occCount[pos]++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (occCount[i] == 0) {
                    sources++;
                }
            }
        }
        return sources;
    }

    public static int checkForIsolatedPairs(int[] passPositions) {
        int N = passPositions.length;
        int pairs = 0;
        if (passPositions.length == 1) {
            pairs = 1;
        } else {
            if (passPositions[0] == 1 && passPositions[1] == 0 && passPositions[2] != 1) {
                pairs++;
            }
            if (passPositions[N-1] == N-2 && passPositions[N-2] == N-1 && passPositions[N-3] != N-2) {
                pairs++;
            }
            for (int pos = 0; pos < N-3; pos++) {
                if (passPositions[pos+1] == pos+2 && passPositions[pos+2] == pos+1 &&
                    passPositions[pos] != pos+1 && passPositions[pos+3] != pos+2) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] positions = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(positions);

        int[] passPositions = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                passPositions[i] = 1;
            } else if (i == N-1) {
                passPositions[i] = N-2;
            } else {
                int left = positions[i] - positions[i-1];
                int right = positions[i+1] - positions[i];
                if (left <= right) {
                    passPositions[i] = i-1;
                } else {
                    passPositions[i] = i+1;
                }
            }
        }

        int sources = checkForSources(passPositions);
        int isolatedPairs = checkForIsolatedPairs(passPositions);

        if (positions.length == 1) {
            pw.println(1);
        } else {
            pw.println(sources+isolatedPairs);
        }

        br.close();
        pw.close();
    }
}