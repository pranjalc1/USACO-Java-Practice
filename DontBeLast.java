import java.io.*;
import java.util.*;

/**
 * DontBeLast
 */
public class DontBeLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new TreeMap<String,Integer>();
        String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        for (String s : cows) {
            map.put(s, 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cow = st.nextToken();
            int before = map.get(cow);
            map.remove(cow);
            map.put(cow, before + Integer.parseInt(st.nextToken()));
        }

        int minimumMilk = Integer.MAX_VALUE;
        for (String cow : map.keySet()) {
            int milk = map.get(cow);
            if (milk < minimumMilk) {minimumMilk = milk;}
        }

        ArrayList<Integer> milkAmounts = new ArrayList<Integer>();
        for (String cow : map.keySet()) {
            if (milkAmounts.size() == 0) {
                if (map.get(cow) > minimumMilk) {milkAmounts.add(map.get(cow));}
            } else if (milkAmounts.size() > 0) {
                if (map.get(cow) < milkAmounts.get(milkAmounts.size()-1) && map.get(cow) > minimumMilk) {
                    milkAmounts = new ArrayList<Integer>();
                    milkAmounts.add(map.get(cow));
                } else if (map.get(cow) == milkAmounts.get(milkAmounts.size()-1)) {
                    milkAmounts.add(map.get(cow));
                }
            }
        }

        if (milkAmounts.size() == 0 || milkAmounts.size() > 1) {
            pw.println("Tie");
        } else {
            for (String cow : map.keySet()) {
                if (map.get(cow) == milkAmounts.get(0)) {
                    pw.println(cow);
                    break;
                }
            }
        }

        br.close();
        pw.close();
    }
}