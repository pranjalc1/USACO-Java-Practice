import java.io.*;
import java.util.*;

/**
 * SwapitySwap2
 */
public class SwapitySwap2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[2];
        int[] B = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            A[i] = Integer.parseInt(st.nextToken())-1;
        }
        A[1]++;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            B[i] = Integer.parseInt(st.nextToken())-1;
        }
        B[1]++;

        int[] positions = new int[N];

        for (int cow = 0; cow < N; cow++) {
            int prevPos = cow;
            ArrayList<Integer> cows = new ArrayList<Integer>();
            cows.add(cow);
            // Adds prevPos to cows as long as prevPos != cow, thus finding period of movement for this cow
            if ((cow >= B[0] && cow < B[1]) || (cow >= A[0] && cow < A[1])) {
                for (int rep = 0; rep < K; rep++) {
                    if (prevPos >= B[0] && prevPos < B[1]) {
                        prevPos = B[1] + B[0] - 1 - prevPos;
                    }
                    if (prevPos >= A[0] && prevPos < A[1]) {
                        prevPos = A[1] + A[0] - 1 - prevPos;
                    }
                    if (prevPos == cow) {
                        break;
                    }
                    cows.add(prevPos);
                }
                prevPos = cows.get(K % cows.size());
            }
            positions[cow] = prevPos;
        }

        for (int element : positions) {
            pw.println(element+1);
        }

        br.close();
        pw.close();
    }
}