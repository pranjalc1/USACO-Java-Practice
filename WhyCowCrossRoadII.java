import java.io.*;
import java.util.*;

/**
 * WhyCowCrossRoadII
 */
public class WhyCowCrossRoadII{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = st.nextToken();

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int intersections = 0;

        for (int i = 0; i < 25; i++) {
            for (int j = i+1; j < 26; j++) {
                char char1 = letters.charAt(i);
                char char2 = letters.charAt(j);
                ArrayList<Integer> indices1 = new ArrayList<Integer>();
                ArrayList<Integer> indices2 = new ArrayList<Integer>();

                for (int k = 0; k < 52; k++) {
                    if (line.charAt(k) == char1) {
                        indices1.add(k);
                    } else if (line.charAt(k) == char2) {
                        indices2.add(k);
                    }
                }

                int a = indices1.get(0);
                int b = indices1.get(1);
                int c = indices2.get(0);
                int d = indices2.get(1);

                if (a < c && b > c && b < d) {
                    intersections++;
                } else if (a > c && a < d && b > d) {
                    intersections++;
                }
            }
        }
        
        pw.println(intersections);

        br.close();
        pw.close();
    }
}