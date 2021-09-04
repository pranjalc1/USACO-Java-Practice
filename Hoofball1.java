import java.io.*;
import java.util.*;

/**
 * Hoofball1
 * Runtime/memory limit exceeded with this solution (with 1 wrong test case)
 */
public class Hoofball1 {
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

        ArrayList<TreeSet<Integer>> allCows = new ArrayList<TreeSet<Integer>>();

        for (int pos = 0; pos < N; pos++) {
            allCows.add(simulate(positions, pos));
        }

        int numBalls = 0;
        while (allCows.size() > 0) {
            int maxReached = 0;
            int maxReacher = 0;

            for (int i = 0; i < allCows.size(); i++) {
                int reached = allCows.get(i).size();
                if (reached > maxReached) {
                    maxReached = reached;
                    maxReacher = i;
                }
            }

            for (int i = 0; i < allCows.size(); i++) {
                for (int j : allCows.get(i)) {
                    System.out.print(j);
                }
                System.out.print("\n*********\n");
            }

            TreeSet<Integer> reacherSet = allCows.get(maxReacher);
            int maxInSet = reacherSet.last();

            for (int i = 0; i < allCows.size(); i++) {
                if (i != maxReacher) {
                    for (int j : reacherSet) {
                        if (allCows.get(i).contains(j)) {
                            allCows.get(i).remove(j);
                        }
                    }
                    TreeSet<Integer> newSet = new TreeSet<Integer>();
                    for (int j : allCows.get(i)) {
                        if (j > maxInSet) {
                            newSet.add(j - maxInSet);
                        } else {
                            newSet.add(j);
                        }
                    }
                    allCows.set(i, newSet);
                }
            }

            int iter = 0;
            ArrayList<Integer> reacherList = new ArrayList<Integer>(reacherSet);
            Collections.sort(reacherList);

            for (int cowToRemove : reacherList) {
                allCows.remove(cowToRemove-iter);
                iter++;
            }

            numBalls += 1;
        }

        pw.println(numBalls);

        br.close();
        pw.close();
    }

    static TreeSet<Integer> simulate(int[] positions, int initPos) {
        TreeSet<Integer> included = new TreeSet<Integer>();
        int pos = initPos;
        int N = positions.length;

        while (true) {
            included.add(pos);

            if (pos == 0) {
                pos = 1;
            } else if (pos == N-1) {
                pos = N-2;
            } else {
                int posValue = positions[pos];
                int before = positions[pos-1];
                int after = positions[pos+1];
                if (posValue - before > after - posValue) {
                    pos += 1;
                } else {
                    pos -= 1;
                }
            }
            
            if (pos > N-1 || pos < 0) {
                break;
            } else if (included.contains(pos)) {
                break;
            }
        }

        return included;
    }
}