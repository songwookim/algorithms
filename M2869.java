import java.io.*;
import java.util.StringTokenizer;

public class M2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a =Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        // v = (a-b)x + b , (v-b)/(a-b) <= n 이 되는 첫 번째 자연수 n
        double n = (double)(v-b)/(a-b);

        if( (int)n < n) {
            n += 1;
        }
        bw.write(""+(int)n);

        br.close();
        bw.close();
    }
}

