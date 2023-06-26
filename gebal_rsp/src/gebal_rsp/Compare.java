package gebal_rsp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//백승현, 이도형
public class Compare {
	int user;
	int com;
	int userWin;
	int comWin;
	int draw;

	boolean flag;

	Scanner sc = new Scanner(System.in);

	public Compare() {

		this.user = user;
		this.com = com;
		userWin = 0;
		comWin = 0;
		draw = 0;
		flag = true;
	}

	public void compare() {
		String userVal = "";
		String comVal = "";
		Random random = new Random();

		System.out.println("1 or 가위 2 or 바위 3 or 보");

		String userInput = sc.nextLine();

		if (userInput.equals("가위") || userInput.equals("1")) {
			this.user = 1;

		} else if (userInput.equals("바위") || userInput.equals("2")) {
			this.user = 2;

		} else if (userInput.equals("보") || userInput.equals("3")) {
			this.user = 3;

		}

		this.com = random.comNum();

		// user 입력값 문자열로 변환
		if (this.user == 1) {
			userVal = "가위";
		} else if (this.user == 2) {
			userVal = "바위";
		} else if (this.user == 3) {
			userVal = "보";
		} else if (this.user >= 4 || this.user <= 0) {
			userVal = null;
		}

		// computer random 값 문자열로 변환
		if (this.com == 1) {
			comVal = "가위";
		} else if (this.com == 2) {
			comVal = "바위";
		} else if (this.com == 3) {
			comVal = "보";

		}

		if ((this.user > this.com) && (this.user < 4 && this.user > 0)) {
			if (this.com == 1 && this.user == 3) {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Computer Win!!" + "\nEnter를 누르세요");
				comWin++;
				System.out.println(userWin);
				sc.nextLine();
				contin();
			} else {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : User Win!!" + "\nEnter를 누르세요");
				userWin++;
				System.out.println(userWin);
				sc.nextLine();
				contin();
			}

		} else if ((this.user < this.com) && (this.user < 4 && this.user > 0)) {
			if (this.user == 1 && this.com == 3) {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : User Win!!" + "\nEnter를 누르세요");
				userWin++;
				System.out.println(comWin);
				sc.nextLine();
				contin();
			} else {

				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Computer Win!!" + "\nEnter를 누르세요");
				comWin++;
				System.out.println(comWin);
				sc.nextLine();
				contin();
			}

		} else if ((this.user == this.com) && (this.user < 4 && this.user > 0)) {
			System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Draw!!" + "\nEnter를 누르세요");
			draw++;
			sc.nextLine();
			contin();
		} else if (this.user >= 4 || this.user <= 0) {

			System.out.println("잘못된 값을 입력하셨습니다.");
			sc.nextLine();
			contin();

		}
	}

	public void contin() {
		int ch;
		while (flag) {
			System.out.println("게임을 계속 하시겠습니까 ?\n1. 재시작 2. 전적확인 3.종료");
			ch = Integer.parseInt(sc.nextLine());
			if (ch == 1) {
				compare();
			} else if (ch == 2) {
				gameRate();

			} else {
				System.out.println("시스템을 종료합니다");
				flag = false;
				System.exit(0);

			}
		}
	}
	
	
//김규호
	public void gameRate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy 년 MM 월dd 일");
		String toDayFormat = sdf.format(date);
		double result = ((double) userWin / (double) ((comWin + userWin + draw))) * 100;
		System.out.println(toDayFormat + " 전적 : 승 (" + userWin + ") 패 (" + comWin + ") 무승부 : (" + draw + ") 승률 ("
				+ (int) result + "%)");

	}

}
