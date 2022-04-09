import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M10808알파벳개수 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            alphabet[(int) input.charAt(i) % (int) 'a']++;
        }
        for(int i : alphabet) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
