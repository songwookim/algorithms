import java.io.*;

public class M2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //String input = br.readLine().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "*");
        String input = br.readLine().replaceAll("[csz]=|[cd]-|dz=|[ln]j", "*");
        int cnt = input.length();

        bw.write(""+cnt);

        br.close();
        bw.close();
    }
}
