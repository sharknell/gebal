package gebal_rsp;

import java.util.Scanner;

public class UserVsCom {
	int user;
	int com;
	int userWin;
	int comWin;
	int draw;

	Scanner sc = new Scanner(System.in);

	public UserVsCom() {
		this.user = user;
		this.com = com;
		userWin = 0;
		comWin = 0;
		draw = 0;
	}
	public void compare() {

		String userVal = "";
		String comVal = "";

		if ((this.user > this.com) && (this.user < 4 && this.user > 0)) {
			if (this.com == 1 && this.user == 3) {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Computer Win!!");
				comWin++;
				System.out.println(userWin);
				sc.nextInt();
			} else {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : User Win!!");
				userWin++;
				System.out.println(userWin);
				sc.nextInt();
			}
		} else if ((this.user < this.com) && (this.user < 4 && this.user > 0)) {
			if (this.user == 1 && this.com == 3) {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : User Win!!");
				userWin++;
				System.out.println(comWin);
				sc.nextInt();
			} else {
				System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Computer Win!!");
				comWin++;
				System.out.println(comWin);
				sc.nextInt();
			}
		} else if ((this.user == this.com) && (this.user < 4 && this.user > 0)) {
			System.out.println("User  : " + userVal + "\nCompter: " + comVal + "\n결과 : Draw!!");
			draw++;
			sc.nextInt();
		} else if (this.user >= 4 || this.user <= 0) {
			System.out.println("잘못된 값을 입력하셨습니다.");
			sc.nextInt();
		}
	}
}