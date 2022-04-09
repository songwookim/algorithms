import java.io.*;

public class M11720 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split("");
        int sum = 0;
        for(int i =0; i< N; i++) {
            sum += Integer.parseInt(strArr[i]);
        }

        bw.write(""+sum);
        bw.close();

        br.close();
        bw.close();
    }
}
