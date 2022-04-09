import java.io.*;
import java.util.*;

public class M11651좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[N][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            int tempX = Integer.parseInt(st.nextToken());
            int tempY = Integer.parseInt(st.nextToken());

            coordinates[i][0] = tempX;
            coordinates[i][1] = tempY;
        }
        Arrays.sort(coordinates, (e1, e2) -> {
            if(e1[1] == e2[1])
                return e1[0] - e2[0];
            return e1[1] - e2[1];
        });
        for (int i = 0; i < N; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            bw.write(x + " " + y + "\n");
        }
        bw.flush();
    }
}
