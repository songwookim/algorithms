import java.io.*;

public class M2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int tempNum;
        int bagNum = -1;

        if(N < 8) {
            if( N == 3  || N == 5 || N == 6) {
                bagNum = N == 6 ? 2 : 1;
            }
        } else {
            tempNum = N%5;
            if(tempNum == 0) { // 5로 나누어 떨어질 때
                bagNum = N/5;
            } else if(tempNum == 3){ // N - 5*n5 - 3 처리
                bagNum = N/5 + 1 ;
            } else { // N - 5*n5 - 3*n3 처리
                int n5 = N/5-1;
                for(int n3 =0; n3 < N/3+1; n3++) {
                    int temp = n5*5 + n3*3;
                    if(N == temp) {
                        bagNum = n5 + n3;
                        break;
                    } else if( N < temp) {
                        n5--;
                        n3--;
                    }
                }
            }
        }
        bw.write(String.format("%d", bagNum));
        bw.flush();

        br.close();
        bw.close();
    }
}
