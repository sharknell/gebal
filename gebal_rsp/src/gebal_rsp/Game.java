package gebal_rsp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Game {
    static int cumwin = 0;
    static int userwin = 0;
    static int rateall = 0;
    static Scanner sc = new Scanner(System.in);

    public static void startGame() {
        System.out.println("가위 1 /바위 2 / 보 3 중 하나를 입력해주세요");
        String[] rok = { " ", "가위", "바위", "보" };
        String str = sc.next();
        int userNum = 0;
        if (str.equals("가위") || str.equals("1")) {
            userNum = 1;
            System.out.println("가위 입력");
        } else if (str.equals("바위") || str.equals("2")) {
            userNum = 2;
            System.out.println("바위 입력");
        } else {
            userNum = 3;
            System.out.println("보 입력");
        }

        int cumNum = (int) (Math.random() * 3 + 1);

        if (cumNum > userNum) {
            if (cumNum == 3 && userNum == 1) {
                userwin++;
                System.out.println("컴퓨터는 : " + rok[cumNum] + " 당신은 :" + rok[userNum] + " 당신 승");
            } else {
                cumwin++;
                System.out.println("컴퓨터는 : " + rok[cumNum] + " 당신은 :" + rok[userNum] + " Cum 승");
            }
        } else if (cumNum < userNum) {
            if (cumNum == 1 && userNum == 3) {
                cumwin++;
                System.out.println("컴퓨터는 : " + rok[cumNum] + " 당신은 :" + rok[userNum] + " Cum 승");
            } else {
                userwin++;
                System.out.println("컴퓨터는 : " + rok[cumNum] + " 당신은 :" + rok[userNum] + " 당신 승");
            }
        } else {
            rateall++;
            System.out.println("무승부");
        }
        gameIng();
    }

    private static void gameIng() {
        while (true) {
            System.out.println("1.게임계속 2.전적보기 3.종료");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    startGame();
                    break;
                case 2:
                    gameRate();
                    break;
                case 3:
                    System.out.println("종료");
                    System.exit(0);
            }
        }
    }

    static void gameRate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        String formattedDateTime = now.format(formatter);
        double result = ((double) userwin / (double) ((cumwin + userwin + rateall))) * 100;
        System.out.println(
                formattedDateTime + " 전적 : 승(" + userwin + ") 패 (" + cumwin + ") 무승부 : " + rateall + " 승률 (" + (int) result + "% )");
    }
}
