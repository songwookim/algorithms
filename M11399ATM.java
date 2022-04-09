import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class M11399ATM {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N ;
    static int[] times;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);

        int sum = 0;
        for (int i = N; i > 0; i--) {
            sum += (i * times[N-i]);
        }
        bw.write(sum + "") ;
        bw.flush();
    }
}
