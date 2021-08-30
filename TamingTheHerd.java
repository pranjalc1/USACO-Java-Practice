import java.io.*;
import java.util.*;

/**
 * TamingTheHerd
 */
public class TamingTheHerd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] log = new int[N];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> filledIn = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            log[i] = Integer.parseInt(st.nextToken());
            if (log[i] > -1) {
                filledIn.add(i);
            }
        }

        boolean noError = true;
        int iter = 0;

        while (noError && iter < filledIn.size()) {
            int newLog = filledIn.get(iter);

            if (log[newLog] > newLog) {
                noError = false;
                break;
            }

            int numDays = log[newLog]-1;
            for (int i = newLog-1; i >= newLog-log[newLog]; i--) {
                if (log[i] != -1 && log[i] != numDays) {
                    noError = false;
                    break;
                } else if (log[i] != -1 && log[i] == numDays) {
                    break;
                } else {
                    log[i] = numDays;
                }
                numDays--;
            }

            iter++;
        }
        
        if (log[0] == -1) {
            log[0] = 0;
        } else if (log[0] != 0) {
            noError = false;
        }

        if (!noError) {
            pw.println(-1);
        } else {
            int negativeCount = 0;
            int zeroCount = 0;
            for (int logElement : log) {
                if (logElement == -1) {
                    negativeCount++;
                } else if (logElement == 0) {
                    zeroCount++;
                }
            }

            int min = zeroCount;
            int max = zeroCount + negativeCount;

            pw.println(min + " " + max);
        }

        br.close();
        pw.close();
    }        
}