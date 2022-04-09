import java.util.Scanner;

public class M3053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();

        System.out.printf("%f\n%f", (double)R*R*Math.PI, (double)R*R*2);
    }
}
