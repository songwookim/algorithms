import java.io.*;

public class M10989카운팅정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] B = new int[10000000]; // 입력 가능한 숫자
        int max = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            B[input] += 1;
            max = Math.max(input, max);
        }

        for (int i = 0; i < max+1; i++) {
            while(B[i] != 0 ){
                bw.write(i+"\n");
                B[i]--;
            }
        }
        bw.flush();
    }
}
