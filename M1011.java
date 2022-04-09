import java.io.*;
import java.util.StringTokenizer;

public class M1011 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {

            int T = Integer.parseInt(br.readLine());
            StringTokenizer st ;
            int x,y ;
            int distance ;
            int times;
            int max;
            double maxSquare;

            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                distance = y - x;

                max = (int) Math.sqrt(distance); // 내림
                maxSquare = Math.pow(max, 2);

                if (distance == maxSquare) {
                    times = 2 * max - 1;
                } else if (distance <= maxSquare + max) {
                    times = 2 * max;
                } else {
                    times = 2 * max + 1;
                }
                bw.write(String.format("%d \n", times));
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
