package JO;

import java.util.*;

public class Main_JO_1205_조커 {
	public static void main(String[] args) {

//      Scanner sc = new Scanner("7 \r\n" + "0 6 5 10 3 0 11");
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cards = new int[N];
		int ans = 0;
		int joker = 0;
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
			if (cards[i] == 0) {
				joker++;
			}
		}

		Arrays.sort(cards); // 0 0 3 5 6 10 11

		if (joker == N) {
			System.out.println(N);
			return;
		}
		for (int i = joker; i < N; i++) {
			// cards[i]=3 시작
			int prev = cards[i];
			int jokercnt = joker;
			int cnt = 1;
			for (int j = i + 1; j < N; j++) {

				// 다음꺼랑 스트레이트
				if (prev + 1 == cards[j]) {
					cnt++;
					prev++;
					continue;
				}
				// 다음꺼랑 같을 때
				if (prev == cards[j]) {
					continue;
				}
				if (jokercnt == 0) {
					break;
				}
				// 그외
				jokercnt--;
				prev++;
				cnt++;
				j--;
			}
			ans = Math.max(ans, cnt + jokercnt);
		}

		// 출력
		System.out.println(ans);
	}
}
