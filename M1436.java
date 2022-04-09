import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0 ;
        int temp = 666;
        while(true) {
            if(String.valueOf(temp).contains("666")) {
                count++;
            }
            if(count == N) {
                break;
            }
            temp++;
        }
        System.out.println(temp);
    }
}
/*
1 666
2 1666
..
10 9666
11 16661 10666
12 11666
13 12666
14 13666
15 14666
16 15666
17 16660
...
24 16669
25 17666
 */
