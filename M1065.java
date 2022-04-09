import java.io.*;

public class M1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        for(int i = 1; i <= N; i++) {
            if(M1065.chkEquatorialDigit(i)) {
                res++;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();

        br.close();
        bw.close();
    }
    
    public static boolean chkEquatorialDigit(int n) {
        int tempNum = n;
        int tempNumLastDigit = n%10;
        tempNum /= 10;        // 한 자릿수 숫자는 while문 통과 후 true
        int d = tempNum%10 - tempNumLastDigit ; // 공차

        while(tempNum >0) {
            int nextDigit = tempNum%10;
            if(tempNumLastDigit + d != nextDigit ) // 등차가 아닌 경우
                return false;
            tempNumLastDigit = nextDigit ;
            tempNum /= 10;
        }
        return true;
    }
}
