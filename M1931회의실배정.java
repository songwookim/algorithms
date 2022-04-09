import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class M1931회의실배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] times;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        times = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(times[i][0], max);
        }
        //Arrays.sort(times, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });


        int endTime = times[0][1];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if(times[i][0] >= endTime) {
                count++;
                endTime = times[i][1];
            }
        }
        bw.write(count+"");
        bw.flush();
    }
}
