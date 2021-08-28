import java.io.*;
import java.util.*;

/**
 * CitiesAndStates
 */
public class CitiesAndStates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Map<String,Long> map = new HashMap<String,Long>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nextCityState = st.nextToken().substring(0,2) + st.nextToken();
            if (!(nextCityState.substring(2).equals(nextCityState.substring(0,2)))) {
                if (!map.containsKey(nextCityState)) {
                    map.put(nextCityState,0L);
                }
                map.put(nextCityState,map.get(nextCityState)+1);
            }
        }

        long patterns = 0L;
        for (String cityState : map.keySet()) {
            String otherCityState = cityState.substring(2) + cityState.substring(0,2);
            if (map.containsKey(otherCityState)) {
                patterns += map.get(cityState) * map.get(otherCityState);
            }
        }

        patterns /= 2;

        pw.println(patterns);

        br.close();
        pw.close();
    }
}