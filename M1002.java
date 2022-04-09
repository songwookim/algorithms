import java.util.Scanner;

public class M1002 {
    public static void main(String[] args) {
        Scanner zz = new Scanner(System.in);
        int T = zz.nextInt();
        for(int i = 0; i < T; i++) {
            int x1 = zz.nextInt();
            int y1 = zz.nextInt();
            int r1 = zz.nextInt();
            int x2 = zz.nextInt();
            int y2 = zz.nextInt();
            int r2 = zz.nextInt();

            double d = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
            int r_subtract = Math.max(r2,r1) - Math.min(r2,r1);
            if(d == 0 && r1 == r2){ // 원이 겹치는 경우
                System.out.println(-1);
            } else if(d > r1+r2 || d < r_subtract) { // 두 원이 아예 떨어져 있거나 작은 원이 큰 원에 내접해 있지 않을 때
                System.out.println(0);
            } else if(d == r_subtract || d == r1+r2 ) { // 내접 or 외접
                System.out.println(1);
            }  else {
                System.out.println(2);
            }
        }
    }
}
