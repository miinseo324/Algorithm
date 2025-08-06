import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int sum =0;
        String[] str = sc.next().split("");
        for (int i=0; i<t; i++) {
            sum += Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}
