import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
//    static StringBuilder sb = new StringBuilder(); // 전역으로 선언하자!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 장대에 쌓인 원판의 개수
//        System.out.println((int) Math.pow(2,n)-1);
        BigInteger moves = BigInteger.TWO.pow(n).subtract(BigInteger.ONE);
        System.out.println(moves);
        if (n<=20) {
            towerOfHanoi(n,1,2,3);
//            System.out.print(sb); // 경로 출력하기 !!
        }
    }

    public static void towerOfHanoi (int n, int from, int m, int to) {
        // n: 원판의개수, from:어디에서 -> to:어디로 이동(목적지) !!
        // 1. 기본 조건
        if (n == 0) {
            return;
        }
        // 2. 재귀 조건
        towerOfHanoi(n-1, from, to, m);
        // n-1번째 원판을 from(1) ->m(2)으로 옮기기! (n-1)개의 원판들이 1->2로 이동하기 전부!
//        sb.append('\n').append(from).append(" ").append(to);
        System.out.println(from+" "+to);
        // 맨 마지막 원판이 from(1)->to(3)으로 이동하기 (1번 이니까!!)
        towerOfHanoi(n-1, m, from, to);
        // n-1번째 원판을 m(2)->to(3)로 마저 옮기기
    }
}
