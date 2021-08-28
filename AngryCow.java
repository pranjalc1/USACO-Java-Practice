import java.io.*;
import java.util.*;

/**
 * AngryCow
 */
public class AngryCow {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] positions = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(positions);

        int maxExploded = 1;

        for (int cow : positions) {
            
            ArrayList<Integer> remainingCows = new ArrayList<Integer>();
            
            for (int pos : positions) {
                if (pos != cow) {
                    remainingCows.add(pos);
                }
            }

            int blastR = 1;
            ArrayList<Integer> blasted = new ArrayList<Integer>();
            blasted.add(cow);
            ArrayList<Integer> removed = new ArrayList<Integer>();

            while (blasted.size() > 0 && remainingCows.size() > 0) {
                for (int blastedCow : blasted) {
                    for (int pos : remainingCows) {
                        if (pos >= blastedCow - blastR && pos <= blastedCow + blastR && !removed.contains(pos)) {
                            removed.add(pos);
                        }
                    }
                }
                // remove and add elements
                blasted = new ArrayList<Integer>();
                for (int pos : removed) {
                    remainingCows.remove(Integer.valueOf(pos));
                    blasted.add(Integer.valueOf(pos));
                }
                removed = new ArrayList<Integer>();
                blastR++;
            }

            int total = N - remainingCows.size();

            if (total > maxExploded) {
                maxExploded = total;
            }
        }

        pw.println(maxExploded);

        br.close();
        pw.close();
    }
}