package day241219;

import java.util.Scanner;

// 프로그래머스 핸드폰 번호 가리기(12948)
/*
[문제 해설]
- 전화번호 뒷 4자리를 제외한 나머지 숫자를 전부 *로 가린 문자열을 return
*/
public class n12948 {

    private static String solution(String phone_number) {
        String answer = "";
        String[] num = phone_number.split("");

        int a = phone_number.length();
        for(int i = 0; i<a; i++) {
            if(i < a-4) {
                answer +="*";
            } else {
                answer += num[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("전화 번호 입력 : ");
        String phone_number = sc.nextLine();

        String answer = solution(phone_number);
        System.out.println("답 : " + answer);
    }
}
