package gebal_rsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameMain {

	public static void main(String[] args) throws Exception {

		Regist regist = new Regist();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch;

		while (true) {
			System.out.println("1. 회원가입 2. 로그인 3. 종료");
			ch = Integer.parseInt(br.readLine());
			if (ch == 1) {
				regist.email();
			} else if (ch == 2) {
				regist.login();
			} else {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}

}
