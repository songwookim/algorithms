import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0) break;
            int max = a*a > b*b ? a*a > c*c ? a*a : c*c : b*b > c*c ? b*b : c*c ;
            if(max == a*a) {
                System.out.println(max == b*b+c*c ? "right" : "wrong");
            } else if(max ==b*b) {
                System.out.println(max == a*a+c*c ? "right" : "wrong");
            } else {
                System.out.println(max == a*a+b*b ? "right" : "wrong");
            }
        }
    }
}
