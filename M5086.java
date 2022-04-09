import java.io.*;
import java.util.StringTokenizer;

public class M5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st ;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a+b == 0) {
                break;
            }

            if(b % a == 0)
                bw.write("factor");
            else if(a % b == 0)
                bw.write("multiple");
            else
                bw.write("neither");

            bw.write("\n");

        }
        bw.flush();
    }
}
