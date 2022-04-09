import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i < T; i++) {
            int temp = Integer.parseInt(st.nextToken());
            boolean isPN = true;
            for(int j = 2; (j-1) < temp/2.0; j++) {
                if(temp % j == 0) {
                    isPN = false;
                }
            }
            if(isPN && temp != 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
