import java.io.*;
import java.util.StringTokenizer;

public class M1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input.trim());

        bw.write(st.countTokens()+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
