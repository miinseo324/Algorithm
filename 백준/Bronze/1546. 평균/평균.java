import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 시험 본 과목의 개수 n
        float max = 0;
        float sum = 0;
        float[] lst = new float[n];

        for (int i = 0; i< n; i++) {
            lst[i] = sc.nextInt();
            if (lst[i] > max) {
                max = lst[i];
            }
        }

        for (int i = 0; i< n;i++) {
            sum += (lst[i]/max)*100;
        }

        System.out.println(sum/n);
    }
}