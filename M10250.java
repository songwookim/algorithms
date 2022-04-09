import java.io.*;
import java.util.StringTokenizer;

public class M10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i =0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            if(floor == 0) floor = H;
            double room = Math.ceil((double)N/H);

            bw.write(String.format("%d%s%d\n", floor, room < 10? "0": "", (int)room));
            bw.flush();
        }
    }
}
