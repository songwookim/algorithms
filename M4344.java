import java.io.*;

public class M4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        for(int i =0; i< C; i++) {
            String[] st = br.readLine().split(" ");
            int N = Integer.parseInt(st[0]);
            int sum = 0;

            for(int idx =1; idx <= N; idx++) {
                sum += Integer.parseInt(st[idx]);
            }

            int z = 0;
            double avg = sum/(double)N;
            for(int idx = 1; idx <= N; idx++) {
                if( Integer.parseInt(st[idx]) > avg) z++;
            }
            bw.write(String.format("%.3f%%%n", (z/(double)N*100.0)));

        }
        bw.flush();
        br.close();
        bw.close();
    }
}
