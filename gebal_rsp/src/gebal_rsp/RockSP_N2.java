package gebal_rsp;

import java.util.*;

class User {
    String username;

    public User(String username) {
        this.username = username; 
    }
}

public class RockSP_N2 {

    public static void main(String[] args) {
        boolean w1 = true;
        while (w1) {
            System.out.println("1.회원가입 2.로그인");
            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    Registration.registerUser();
                    break;
                case 2:
                    login();
                    w1 = false;
                    break;
                case 3:
                    Game.startGame();
                    break;
            }

        }
        System.out.println("게임을 시작합니다");

        while (!w1) {
            System.out.println("1.게임시작 2.현재 전적보기 3.끝내기");
            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    Game.startGame();
                    break;
                case 2:
                    Game.gameRate();
                    break;
                case 3:
                    w1 = false;
            }
        }

    }

    private static void login() {
        System.out.print("아이디: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        boolean loggedIn = false;

        for (User user : Registration.users) {
            if (user.username.equals(username)) {
                loggedIn = true;
                break;
            }
        }

        if (loggedIn) {
            System.out.println("로그인 성공!");
            // 로그인에 성공한 후에 실행할 작업을 추가합니다
        } else {
            System.out.println("로그인 실패. 아이디를 확인하세요.");
        }
    }
}
