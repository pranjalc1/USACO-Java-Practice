import java.io.*;
import java.util.*;

/**
 * GrassPlanting
 * Solution inspired by official solution
 */
public class GrassPlanting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] connections = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            connections[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            connections[a].add(b);
            connections[b].add(a);
        }

        int maxDegree = 0;
        for (int i = 0; i < N; i++) {
            if (connections[i].size() > maxDegree) {
                maxDegree = connections[i].size();
            }
        }
        maxDegree++;

        pw.println(maxDegree);

        br.close();
        pw.close();
    }
}