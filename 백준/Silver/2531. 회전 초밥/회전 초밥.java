import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        // deque를 2개 만든다.
        Deque<Integer> check_q = new ArrayDeque<>();
        Deque<Integer> q = new ArrayDeque<>();

        int sushi; int cnt = 0;
        for (int i =0; i<k; i++) {
            sushi = Integer.parseInt(br.readLine());
            if (!check_q.contains(sushi) && sushi != c) { // check_q 안에 입력받은 값이 없고, 입력받은 값이 쿠폰번호(c)가 아니라면,
                cnt +=1; // cnt ++ 하기!
            }
            check_q.addLast(sushi);
        }
        int max = cnt;

        // 나머지 스시도 q에 넣어주기
        for (int i =0; i<(n-k); i++) {
            q.addFirst(Integer.parseInt(br.readLine()));
        }

        // k개씩 점검하기
        for (int i=0; i<n; i++) {
            sushi = check_q.pollFirst(); // check_q에서 하나 빼서 확인
            if (!check_q.contains(sushi) && sushi != c) {
                cnt--;
            }
            q.addFirst(sushi); // check_q에서 하나 빼서 q에 넣고

            sushi = q.pollLast(); // q에서 뺀 것을 sushi 변수에 넣고 체크 시작
            if (!check_q.contains(sushi) && sushi != c) {
                cnt++;
            }
            check_q.addLast(sushi);

            if (max < cnt) {
                max = cnt;
            }
        }

        System.out.println(max+1);
        br.close();
    }
}
