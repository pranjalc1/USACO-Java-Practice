import java.io.*;
import java.util.*;

/**
 * LivestockLineup
 */
public class LivestockLineup {

    public static int countOccurences(ArrayList<String> arr, String x) {
        int count = 0;
        for (String a : arr) {
            if (a.equals(x)) {
                count++;
            }
        }
        return count;
    }

    public static int countOccurences(int[] arr, int x) {
        int count = 0;
        for (int a : arr) {
            if (a == x) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> conditions = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            conditions.add(st.nextToken());
            
            for (int j = 0; j < 4; j++) {
                String k = st.nextToken();
            }

            conditions.add(st.nextToken());
        }
        System.out.println(conditions);

        String[] cows1 = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        ArrayList<String> cows = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            cows.add(cows1[i]);
        }

        int[] occurences = new int[8];
        for (int i = 0; i < 8; i++) {
            occurences[i] = countOccurences(conditions, cows.get(i));
        }

        ArrayList<String> bestOrder = new ArrayList<String>();
        boolean occurs = false;
        int cow = 0;

        while (bestOrder.size() < 8) {
            System.out.println(conditions);
            if (occurs) {
                int place = (int) conditions.indexOf(cows.get(cow)) / 2;
                place *= 2;
                int first = conditions.indexOf(cows.get(cow)) % 2;
                String nextCow = "";
                if (first == 0) {
                    nextCow = conditions.get(place+1);
                } else {
                    nextCow = conditions.get(place);
                }

                bestOrder.add(nextCow);

                conditions.remove(place); conditions.remove(place);

                cow = cows.indexOf(nextCow);
                if (occurences[cow] == 2) {
                    occurs = true;
                } else {
                    cow = 0;
                    occurs = false;
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    if (occurences[i] < 2 && !bestOrder.contains(cows.get(i))) {
                        bestOrder.add(cows.get(i));
                        if (occurences[i] == 1) {
                            occurs = true;
                            cow = i;
                        }
                        break;
                    }
                }
            }
        }

        for (String c : bestOrder) {
            pw.println(c);
        }

        br.close();
        pw.close();
    }
}