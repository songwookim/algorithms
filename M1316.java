import java.io.*;
import java.util.HashSet;

public class M1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0 ;
        boolean check ;

        for(int i =0 ; i < N ; i++) {
            String input = br.readLine();
            HashSet<Character> hashSet = new HashSet<>();
            check = true;

            for(int j = 0; j < input.length() ; j++) {
                if(hashSet.contains(input.charAt(j)) && input.charAt(j-1) != input.charAt(j)) {
                    // 처음나오는 aaa가 여기 걸러지지 않도록 하기 + 나중에 나오는 aaa 거르기
                    // 인자 0인 경우, 첫번째 조건에서 false라서 outboundExcep 발생 x
                    check = false;
                    break;
                } else {
                    hashSet.add(input.charAt(j));
                }
            }
            if(check) count++;
        }
        bw.write(""+count);

        br.close();
        bw.close();
    }
}
