import java.io.*;

public class M10809 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] index = new int[26];
        String str = br.readLine();

        for(int i =0; i < 26; i++) {
            index[i] = str.indexOf((char)i+ (int)'a');
            bw.write(index[i] + " ");
        }
        bw.write("\b");
        bw.flush();

        br.close();
        bw.close();
    }
}
