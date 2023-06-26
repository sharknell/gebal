package gebal_rsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Regist {
	BufferedReader br;
	String email;
	Data data;
	boolean flag; // while 반복문 제어자
	private List<Data> datas; // Data 클래스에 필드를 이용해 리스트에 회원 정보 저장

	Compare compare = new Compare();
	Random random = new Random();

	public Regist() { // 회원가입 생성자
		datas = new ArrayList<>();
		br = new BufferedReader(new InputStreamReader(System.in));
		flag = true;
	}

	public void email() throws Exception {

		System.out.println("이메일을 입력해주세요.");
		email = br.readLine();

		while (true) { // 이메일 @ 포함 검증
			if (email.contains("@")) {
				String[] sp = email.split("@");
				String id = sp[0]; //
				String server = sp[1];
				int ret1Leng = id.length();

				if (ret1Leng >= 8 && ret1Leng <= 12) { // 길이 검증
					char a = 'A';
					char z = 'Z';

					if (id.charAt(0) >= a && id.charAt(0) <= z) { // 대문자 검증
						if (id.contains("1") || id.contains("2") || id.contains("3") || id.contains("4")
								|| id.contains("5") || id.contains("6") || id.contains("7") || id.contains("8")
								|| id.contains("9") || id.contains("0")) {

							System.out.println("[회원가입 성공]\nemail : " + email + "\nid : " + id + "\nserver : " + server);
							datas.add(new Data(id, server));
							break;

						} else {
							System.out.println("[회원가입 실패] 숫자를 포함해주세요.");
						} // 숫자 검증 끝
					} else {
						System.out.println("[회원가입 실패] 첫 문자에 대문자를 포함해주세요.");
					} // 대문자 검증 끝
				} else {
					System.out.println("[회원가입 실패] 8 ~ 12자의 아이디를 입력하세요.");
				} // 길이 검증 끝
			} else {
				System.out.println("[회원가입 실패] 다시 입력해주세요.");
			} // 회원 가입 검증 끝

			// 다시 입력 받기
			System.out.println("이메일을 입력하세요");
			email = br.readLine();
		}
	}// email 검증 메소드 끝

	public void login() throws Exception {
		int ch;

		while (flag) { // 제어자 flag를 이용한 반복문
			System.out.println("로그인 창입니다.");
			String id;
			String serverString;
			System.out.println("ID(email 앞 부분) 을 입력해주세요.");
			id = br.readLine();
			for (int i = 0; i < datas.size(); i++) { // id 검증
				if (id.equals(datas.get(i).getId())) {
					System.out.println("ID : " + id);
					System.out.println("Server( 도메인 ) 을 입력해주세요.");
					serverString = br.readLine();
					if (serverString.equals(datas.get(i).getServer())) { // server 검증
						System.out.println("Server : " + serverString);
						System.out.println("로그인 성공\n ID : " + id + "\nServer : " + serverString);

						// 로그인 성공 시 game 시작
						System.out.println("1. 게임시작 2. 전적확인 3. 나가기");
						int ch1 = Integer.parseInt(br.readLine());
						int com = Random.comNum();
						switch (ch1) {
						case 1:
							compare.compare();
							break;
						case 2:
							compare.gameRate();
							break;

						case 3:
							System.out.println("시스템을 종료합니다.");
							System.exit(0);

						}
						// 로그인 성공 시 반복문 제어자 false로 변경하여 while문 탈출
						flag = false;
					}

					else {
						System.out.println("server가 다릅니다. 재입력 바랍니다.");
					}
				}

				else {
					System.out.println("ID가 틀립니다. 재입력해주세요.");

				}
			}
		}
	}

}
