package day250401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 모음 사전(84512)
/*
[문제 설명]
- 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는 길이 5 이하의 모든 단어가 수록되어 있다.
- 단어 하나가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하시오.
*/
public class n84512 {

    static List<String> list = new ArrayList<>();
    static char[] words = {'A', 'E', 'I', 'O', 'U'};

    private static int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    private static void dfs(String current, int depth) {
        if (depth > 5) return;
        list.add(current);

        for (char word : words) {
            dfs(current + word, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("단어 입력 : ");
        String word = sc.nextLine();
        int result = solution(word);
        System.out.print("답 : " + result);
    }
}
