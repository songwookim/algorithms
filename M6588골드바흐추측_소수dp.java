import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M6588골드바흐추측_소수dp {
    static int[] isCn = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int input = -1;
        boolean flag;
        isCn[0] = 1;
        isCn[1] = 1;
        cn(1000000);
        while (input != 0) {
            input = Integer.parseInt(br.readLine());
            flag = false;
            for (int i = 3; i < input; i += 2) {
                if (isCn[input - i] == 0 && isCn[i] == 0) { // 두 홀수인 소수
                    sb.append(input).append(" = ").append(i).append(" + ").append(input - i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag && input != 0) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void cn(int endNum) {
        if (isCn[endNum] == 0) {
            for (int temp = 2; temp <= Math.sqrt(endNum); temp++) {
                if (isCn[temp] == 1) continue; // 체크된 거면 넘어가기
                for (int tempPn = (int) Math.pow(temp, 2); tempPn <= endNum; tempPn += temp) {
                    isCn[tempPn] = 1;            // 2~root(k) 까지 k배수 제외
                }
            }
        }

    }
}
