import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class M18870좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int tempIdx = 0;
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            origin[tempIdx] = sorted[tempIdx] = input;
        }
        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            if (!hashMap.containsKey(rank)) {
                hashMap.put(v, rank);
                rank++;
            }
        }

        for (int o : origin) {
            bw.write(hashMap.get(o) + " ");
        }
        bw.flush();
    }
}
