import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M9093단어뒤집기 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while(N-->0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                for (int i = temp.length()-1; i > -1; i--) {
                    sb.append(temp.charAt(i));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
