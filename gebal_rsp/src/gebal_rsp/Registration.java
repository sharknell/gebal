package gebal_rsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Registration {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();

    public static void registerUser() {
        while (true) {
            System.out.println(">>E mail을 입력해주세요");
            String email = sc.next(); // email 입력 받음

            int idx = email.indexOf("@");
            String id = email.substring(0, idx);

            char[] arr = id.toCharArray(); // char 배열로 각각 문자 담음

            int upperCount = 0;
            int digitCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i]) == true)
                    upperCount++;
            }

            if (upperCount != 0) {
                // System.out.println("대문자 있음");
            } else {
                System.out.println("대문자 없음");
                continue;
            }
            
            for (int i = 0; i < arr.length; i++) {
                if (Character.isDigit(arr[i])) {
                    digitCount++;
                }
            }
            if (digitCount != 0) {
                // System.out.println("숫자 있음");
            } else {
                System.out.println("숫자 없음");
                continue;
            }

            if (id.length() >= 8 && id.length() <= 12) {
                // System.out.println("길이 좋음");
            } else {
                System.out.println("8자 12자 사0이로 다시");
                continue;
            }

            if (checkUsernameExists(email)) {
                System.out.println("이미 사용 중인 아이디입니다.");
                continue;
            } else {
                users.add(new User(email));
                System.out.println("회원가입 축하합니다");
                break;
            }
        }
    }

    private static boolean checkUsernameExists(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true; // 아이디 중복
            }
        }
        return false; // 아이디 중복 아님
    }
}


