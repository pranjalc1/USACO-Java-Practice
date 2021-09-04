import java.io.*;
import java.util.*;

/**
 * SwapitySwap1
 * Works for first 6 test cases but times out after
 */
public class SwapitySwap1 {
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
        for (int i = 1; i <= N; i++) {
            positions[i-1] = i;
        }

        for (int rep = 0; rep < K; rep++) {
            for (int i = A[0]; i < (A[1]+A[0])/2; i++) {
                int temp = positions[i];
                positions[i] = positions[A[1]+A[0]-1-i];
                positions[A[1]+A[0]-1-i] = temp;
            }
            for (int i = B[0]; i < (B[1]+B[0])/2; i++) {
                int temp = positions[i];
                positions[i] = positions[B[1]+B[0]-1-i];
                positions[B[1]+B[0]-1-i] = temp;
            }
        }

        for (int element : positions) {
            pw.println(element);
        }

        br.close();
        pw.close();
    }
}