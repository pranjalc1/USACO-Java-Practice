import java.io.*;
import java.util.*;

/**
 * OutOfPlace
 */
public class OutOfPlace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> heightsArray = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            if (heightsArray.size() == 0) {
                heightsArray.add(height);
            } else if (heightsArray.get(heightsArray.size()-1) != height) {
                heightsArray.add(height);
            }
        }

        int[] heights = new int[heightsArray.size()];
        int i = 0;
        for (int height : heightsArray) {
            heights[i] = height;
            i++;
        }

        int swaps = 0;
        while (true) {
            for (int j = 0; j < N-1; j++) {
                if (heights[j] > heights[j+1]) {
                    int temp = heights[j];
                    heights[j] = heights[j+1];
                    heights[j+1] = temp;
                    swaps++;
                    break;
                }
            }
            int[] orderedHeights = Arrays.copyOf(heights, heights.length);
            Arrays.sort(orderedHeights);
            if (Arrays.equals(orderedHeights, heights)) {
                break;
            }
        }

        pw.println(swaps);

        br.close();
        pw.close();
    }
}